public class Main {
    public static void main(String[] args) {
        
        TabelaHash tabela = new TabelaHash(10); // Cria uma tabela hash com 10 posições

        // Inserir alunos na tabela
        tabela.inserir(new Aluno(123, "Emilly"));
        tabela.inserir(new Aluno(456, "Pietra"));
        tabela.inserir(new Aluno(789, "Beatriz"));
      

        tabela.imprimir(); 

        // Buscar um aluno
        int buscarMatricula = 456;
        Aluno alunoEncontrado = tabela.buscar(buscarMatricula);
        
        if (alunoEncontrado != null) 
        {
            System.out.println("Aluno com matrícula " + buscarMatricula + " encontrado: " + alunoEncontrado.obterNome());
        } 
        else {
            System.out.println("Aluno com matrícula " + buscarMatricula + " não encontrado.");
        }

        // Remover um aluno
        int removerMatricula = 789;
        tabela.remover(removerMatricula);
        System.out.println("Aluno com matrícula " + removerMatricula + " removido.");

        tabela.imprimir(); // Mostrar a tabela após a remoção
    }
}
