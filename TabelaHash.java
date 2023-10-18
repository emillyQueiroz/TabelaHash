public class TabelaHash {

    private int tam_max_tabela;
    private int qtd_itens; 
    private Aluno[] estrutura; 
    private double fatorDeCargaLimite = 0.7; // Fator de carga, aumenta a capacidade da tabela

    
    public TabelaHash(int tam_vet) {
        this.tam_max_tabela = tam_vet; 
        this.qtd_itens = 0; 
        this.estrutura = new Aluno[tam_vet]; 
    }

    
    public int obterTamanhoAtual() {
        return qtd_itens;
    }

    // Verifica se a tabela está cheia com base no fator de carga
    public boolean estaCheio() {
        // Calcula o fator de carga
        double fatorCarga = (double) qtd_itens / tam_max_tabela;
        
        // Verifica se o fator de carga ultrapassou o limite
        return fatorCarga >= fatorDeCargaLimite;
    }

    // Remove um elemento da tabela com base na matrícula do aluno
    public void remover(int matricula) {
        int local = FuncaoHash(matricula);

        for (int i = 0; i < tam_max_tabela; i++) {
            if (estrutura[local] != null && estrutura[local].obterMatricula() == matricula) {
                System.out.println("Aluno foi removido");
                estrutura[local] = null;
                qtd_itens--;
                return;
            }
            local = (local + 1) % tam_max_tabela;
        }

        System.out.println("Aluno não encontrado!");
    }

    // Insere um aluno na tabela
    public void inserir(Aluno aluno) {
      
        if (estaCheio()) {
            aumentarCapacidade(); // Aumenta a capacidade da tabela se estiver cheia
        }

        int local = FuncaoHash(aluno.obterMatricula());

        while (estrutura[local] != null) {
            local = (local + 1) % tam_max_tabela;
        }

        estrutura[local] = aluno;
        qtd_itens++;
    }

    // Busca um aluno da matricula pedida
    public Aluno buscar(int matricula) {
        int local = FuncaoHash(matricula);

        for (int i = 0; i < tam_max_tabela; i++) {
            if (estrutura[local] != null && estrutura[local].obterMatricula() == matricula) {
                return estrutura[local];
            }
            local = (local + 1) % tam_max_tabela;
        }

        return null; // Retorna null se o aluno não for encontrado
    }

    // Função de hash, verifia posição com base na matrícula
    private int FuncaoHash(int matricula) {
        return matricula % tam_max_tabela;
    }

    // Aumenta a capacidade da tabela e reorganiza os elementos
    private void aumentarCapacidade() {
        int novoTamanho = tam_max_tabela * 2;
        Aluno[] novaEstrutura = new Aluno[novoTamanho];

        for (Aluno aluno : estrutura) {
            if (aluno != null) {
                int local = FuncaoHash(aluno.obterMatricula());

                while (novaEstrutura[local] != null) {
                    local = (local + 1) % novoTamanho;
                }

                novaEstrutura[local] = aluno;
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
                System.out.print(i + ": " + estrutura[i].obterMatricula() + " ");
                System.out.println(estrutura[i].obterNome());
            }
        }
    }
}
