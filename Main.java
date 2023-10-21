public class Main {
    public static void main(String[] args) {
        // Tabela com Tratamento de Colisões por Sondagem Linear
        TabelaHash tabelaLinear = new TabelaHash(10); // Tamanho inicial da tabela

        Aluno aluno1 = new Aluno(10, "Beatriz");
        Aluno aluno2 = new Aluno(15, "Pietra");
        Aluno aluno3 = new Aluno(20, "Amanda");
        Aluno aluno4 = new Aluno(10, "Micael");
        Aluno aluno5 = new Aluno(50, "Barros");

        System.out.println("Inserindo alunos na Tabela com Tratamento de Colisões por Sondagem Linear:");
        tabelaLinear.inserir(aluno1);
        tabelaLinear.inserir(aluno2);
        tabelaLinear.inserir(aluno3);
        tabelaLinear.inserir(aluno4);
        tabelaLinear.inserir(aluno5);

       // imprime a tabela 
        tabelaLinear.imprimir();

        // Busca o aluno solicitando
        int matriculaBuscaLinear = 10;
        Aluno alunoEncontradoLinear = tabelaLinear.buscar(matriculaBuscaLinear);
        if (alunoEncontradoLinear != null) {
            System.out.println("Aluno encontrado  " + alunoEncontradoLinear.obterNome());
        } else {
            System.out.println("Aluno não encontrado!.");
        }
        // remove o alunos solicitando
        int matriculaRemocaoLinear = 10;
        tabelaLinear.remover(matriculaRemocaoLinear);

        tabelaLinear.imprimir();

        System.out.println("---------------------------------------------------------------------------------------------------\n");

        // Tabela com Tratamento de Colisões por Encadeamento
        ColisoesEncadeamento tabelaEncadeamento = new ColisoesEncadeamento(10);

        Aluno aluno6 = new Aluno(60, "Beatriz");
        Aluno aluno7 = new Aluno(71, "Pietra");
        Aluno aluno8 = new Aluno(60, "Amanda");
        Aluno aluno9 = new Aluno(91, "Micael");
        Aluno aluno10 = new Aluno(10, "Barros");

        System.out.println("Inserindo alunos na Tabela com Tratamento de Colisões por Encadeamento:");
        tabelaEncadeamento.inserir(aluno6.obterMatricula(), aluno6);
        tabelaEncadeamento.inserir(aluno7.obterMatricula(), aluno7);
        tabelaEncadeamento.inserir(aluno8.obterMatricula(), aluno8);
        tabelaEncadeamento.inserir(aluno9.obterMatricula(), aluno9);
        tabelaEncadeamento.inserir(aluno10.obterMatricula(), aluno10);

        // Mostrar a tabela de encadeamento com colisões
        tabelaEncadeamento.imprimir();

        // Busca o aluno solicitando
        int BuscaEncadeamento = 71;
        Aluno EncontradoEncadeamento = tabelaEncadeamento.buscar(BuscaEncadeamento);
        if (EncontradoEncadeamento != null) {
            System.out.println( EncontradoEncadeamento.obterNome() + " foi encontrada " );
        } else {
            System.out.println("Aluno não encontrado na tabela de encadeamento.");
        }

        // remover o aluno solicitando
        int matriculaRemocaoEncadeamento = 60;
        Aluno alunoRemovido = tabelaEncadeamento.remover(matriculaRemocaoEncadeamento, aluno6);
        
        if (alunoRemovido != null) {
            System.out.println( alunoRemovido.obterNome() + " foi removido! ") ;
        } else {
            System.out.println("Aluno não encontrado!");
        }
        
        tabelaEncadeamento.imprimir();
    }
}