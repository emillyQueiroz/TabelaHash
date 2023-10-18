public class Aluno {
    private int matricula;
    private String nome;
    
    // construtor de aluno 
    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public int obterMatricula() {
        return matricula;
    }

    public String obterNome() {
        return nome;
    }
}