import java.util.LinkedList;

public class ColisoesEncadeamento {
    private LinkedList<Aluno>[] listaEncadeada;

    public ColisoesEncadeamento(int tamanhoTabela) {
        listaEncadeada = new LinkedList[tamanhoTabela];
        for (int i = 0; i < tamanhoTabela; i++) {
            listaEncadeada[i] = new LinkedList<Aluno>();
        }
    }

    // Insere um aluno na lista encadeada 
    public void inserir(int matricula, Aluno aluno) {
        int indice = FuncaoHash(matricula);
        LinkedList<Aluno> lista = listaEncadeada[indice];

        // Verifica se já existe um aluno com a mesma matricula 
        for (Aluno a : lista) {
            if (a.obterMatricula() == matricula) {
                System.out.println("Colisão detectada: " + a.obterNome() + " colidiu com " + aluno.obterNome());
                break;
            }
        }

        lista.add(aluno);
    }

    // Remove um aluno
    public Aluno remover(int matricula, Aluno aluno) {
        int indice = FuncaoHash(matricula);
        LinkedList<Aluno> lista = listaEncadeada[indice];
    
        for (Aluno a : lista) {
            if (a.obterMatricula() == matricula) {
                lista.remove(a);
                return a;
            }
        }
        return null;
    }
    

    // Busca um aluno 
    public Aluno buscar(int matricula) {
        int indice = FuncaoHash(matricula);
        for (Aluno aluno : listaEncadeada[indice]) {
            if (aluno.obterMatricula() == matricula) {
                return aluno;
            }
        }
        return null; 
    }

    // Função de dispersão 
    private int FuncaoHash(int matricula) {
        return matricula % listaEncadeada.length;
    }

    public void imprimir() {
    
        for (int i = 0; i < listaEncadeada.length; i++) {
            System.out.print(i + ": ");
            LinkedList<Aluno> lista = listaEncadeada[i];
            for (Aluno aluno : lista) {
                System.out.print(aluno.obterMatricula() + " " + aluno.obterNome() + " ");
            }
            System.out.println();
        }
    }
}
