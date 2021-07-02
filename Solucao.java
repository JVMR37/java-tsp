import java.util.List;

public class Solucao {
    public List<Cidade> caminho;
    public double distancia;

    public Solucao(List<Cidade> caminho, double distancia) {
        this.caminho = caminho;
        this.distancia = distancia;
    }

    public Solucao(List<Cidade> caminho) {
        this.caminho = caminho;
    }

    public Solucao() {
    }

    public static Solucao copyOf(Solucao solucaoToCopy) {
        return new Solucao(solucaoToCopy.caminho, solucaoToCopy.distancia);
    }

}
