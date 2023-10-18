import java.util.LinkedList;

public class TabelaHash {

    private int tam_max_tabela;
    private int qtd_itens;
    private LinkedList<Aluno>[] estrutura; // Usando LinkedList para o encadeamento
    private double fatorDeCargaLimite = 0.7; // para aumentar a carga da tabela 

    public TabelaHash(int tam_vet) {
        this.tam_max_tabela = tam_vet;
        this.qtd_itens = 0;
        this.estrutura = new LinkedList[tam_vet]; // Inicializa uma lista encadeada
    }

    public int obterTamanhoAtual() {
        return qtd_itens;
    }

    // Verifica se a tabela está cheia 
    public boolean estaCheio() {

        // Calcula o fator de carga
        double fatorCarga = (double) qtd_itens / tam_max_tabela;

        // Verifica se o fator de carga ultrapassou o limite
        return fatorCarga >= fatorDeCargaLimite;
    }

    // Remove um aluno da tabela
    public void remover(int matricula) {
    // Calcula o índice usando a função de hash
    int local = FuncaoHash(matricula);

    // Verifica se há alguma lista de alunos no índice calculado
    if (estrutura[local] != null) {
        // Itera sobre a lista de alunos no índice
        for (Aluno aluno : estrutura[local]) {
            // Verifica se o aluno possui a matrícula desejada
            if (aluno.obterMatricula() == matricula) {
                // Remove o aluno da lista
                estrutura[local].remove(aluno);
                // Decrementa a quantidade de itens na tabela
                qtd_itens--;
                // Imprime uma mensagem indicando que o aluno foi removido
                System.out.println("Aluno foi removido");
                return; // Retorna imediatamente após a remoção
            }
        }
    }
    

    System.out.println("Aluno não encontrado!");
}

    // Insere um aluno na tabela (usando sondagem linear)
    public void inserir(Aluno aluno) {
    // Verifica se a tabela está cheia
    if (estaCheio()) {
        aumentarCapacidade(); // Aumenta a capacidade da tabela se estiver cheia
    }

    int local = FuncaoHash(aluno.obterMatricula());

    // Cria uma lista, se não existir ainda 
    if (estrutura[local] == null) {
        estrutura[local] = new LinkedList<>();
    }

    // Adiciona o aluno à lista associada a esse índice
    estrutura[local].add(aluno);
    // Incrementa a contagem de itens na tabela
    qtd_itens++;
}

    // Busca um aluno pela matrícula (por encadeamento)
    public Aluno buscar(int matricula) {
    // Calcula o índice usando a função de hash
    int local = FuncaoHash(matricula);

    // Verifica se há alguma lista de alunos no índice calculado
    if (estrutura[local] != null) {
        
        for (Aluno aluno : estrutura[local]) {
            // Verifica se o aluno possui a matrícula pedida
            if (aluno.obterMatricula() == matricula) {
                // Retorna o aluno encontrado
                return aluno;
            }
        }
    }
    
   
    return null;
}

    // Função de hash verifica a posição pela matrícula
    private int FuncaoHash(int matricula) {
        return matricula % tam_max_tabela;
    }

    // Aumenta a capacidade da tabela
    private void aumentarCapacidade() {
        int novoTamanho = tam_max_tabela * 2;
        LinkedList<Aluno>[] novaEstrutura = new LinkedList[novoTamanho];

        for (LinkedList<Aluno> lista : estrutura) {
            if (lista != null) {
                for (Aluno aluno : lista) {
                    int local = FuncaoHash(aluno.obterMatricula());

                    if (novaEstrutura[local] == null) {
                        novaEstrutura[local] = new LinkedList<>();
                    }

                    novaEstrutura[local].add(aluno);
                }
            }
        }

        estrutura = novaEstrutura;
        tam_max_tabela = novoTamanho;
    }

    // Imprime a tabela
    public void imprimir() {
        System.out.println("TabelaHash:");
        for (int i = 0; i < tam_max_tabela; i++) {
            if (estrutura[i] != null) {
                for (Aluno aluno : estrutura[i]) {
                    System.out.print(i + ": " + aluno.obterMatricula() + " ");
                    System.out.println(aluno.obterNome());
                }
            }
        }
    }
}
