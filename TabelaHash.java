public class TabelaHash {
    private int tam_max_tabela;            // Tamanho máximo da tabela 
    private int qtd_itens;                
    private Aluno[] estrutura;           
    private double fatorDeCargaLimite = 0.7; // Fator de carga limite para redimensionar a tabela

    // Construtor da classe
    public TabelaHash(int tam_vet) {
        this.tam_max_tabela = tam_vet;
        this.qtd_itens = 0;
        this.estrutura = new Aluno[tam_vet];
    }

    // Retorna a quantidade de itens na tabela
    public int obterTamanhoAtual() {
        return qtd_itens;
    }

    // Verifica se a tabela está cheia
    public boolean estaCheio() {
        return qtd_itens >= fatorDeCargaLimite * tam_max_tabela;
    }

    // Remove um aluno com base na matrícula
    public void remover(int matricula) {
        int local = FuncaoHash(matricula);
    
        for (int i = 0; i < tam_max_tabela; i++) {
            if (estrutura[local] != null && estrutura[local].obterMatricula() == matricula) {
                Aluno alunoRemovido = estrutura[local];
                estrutura[local] = null;
                qtd_itens--;
                System.out.println("Aluno " + alunoRemovido.obterNome() + (" foi removido"));
                return;
            }
            local = (local + 1) % tam_max_tabela;
        }
    
        System.out.println("Aluno não encontrado!");
    }

    // Insere um aluno na tabela
    public void inserir(Aluno aluno) {
        if (estaCheio()) {
            aumentarCapacidade();
        }
    
        int local = FuncaoHash(aluno.obterMatricula());
    
        while (estrutura[local] != null) {
            if (estrutura[local].obterMatricula() == aluno.obterMatricula()) {
                System.out.println("\nColisão no índice " + local + ": " + estrutura[local].obterNome() + " colidiu com " + aluno.obterNome());
                break;
            }
            local = resolverColisao(local, tam_max_tabela); // Usando sondagem linear 
        }
    
        estrutura[local] = aluno;
        qtd_itens++;
    }

    // Busca um aluno na tabela com base na matrícula
    public Aluno buscar(int matricula) {
        int local = FuncaoHash(matricula);

        for (int i = 0; i < tam_max_tabela; i++) {
            if (estrutura[local] != null && estrutura[local].obterMatricula() == matricula) {
                return estrutura[local];
            }
            local = (local + 1) % tam_max_tabela;
        }

        return null;
    }

    // Função de dispersão que retorna o índice na tabela com base na matrícula
    private int FuncaoHash(int matricula) {
        return matricula % tam_max_tabela;
    }

    // Muda a tabela, aumentando seu tamanho
    private void aumentarCapacidade() {
        int novoTamanho = tam_max_tabela * 2;
        Aluno[] novaEstrutura = new Aluno[novoTamanho];

        for (Aluno aluno : estrutura) {
            if (aluno != null) {
                int local = FuncaoHash(aluno.obterMatricula());

                while (novaEstrutura[local] != null) {
                    local = resolverColisao(local, novoTamanho); // Usando a lógica de sondagem linear diretamente
                }

                novaEstrutura[local] = aluno;
            }
        }

        estrutura = novaEstrutura;
        tam_max_tabela = novoTamanho;
    }

    // Lógica de sondagem linear para resolver colisões
    private int resolverColisao(int indice, int tamanhoTabela) {
        
        return (indice + 1) % tamanhoTabela;
    }

    // Imprime os elementos da tabela de dispersão
    public void imprimir() {

        for (int i = 0; i < tam_max_tabela; i++) {
            if (estrutura[i] != null) {
                System.out.print(i + ": " + estrutura[i].obterMatricula() + " ");
                System.out.println(estrutura[i].obterNome());
            }
        }
    }
}
