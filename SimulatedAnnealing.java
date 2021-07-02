import java.io.IOException;
import java.util.List;

public class SimulatedAnnealing {
    public static void main(String[] args) throws IOException {

        double tempMax = 7;
        double taxaResf = 0.9999999;
        double tempMin = 1e-15;
        int maxIter = 100000;

        gerarRelatorio(tempMax, taxaResf, tempMin, maxIter);

    }

    private static void gerarRelatorio(double tempMax, double taxaResf, double tempMin, int maxIter)
            throws IOException {
        String[] listaDeArquivos = { "att48.tsp.txt", "berlin52.tsp.txt", "bier127.tsp.txt", "eil101.tsp.txt",
                "eil76.tsp.txt", "kroA100.tsp.txt", "kroE100.tsp.txt", "pr76.tsp.txt", "rat99.tsp.txt",
                "st70.tsp.txt" };

        for (String nomeDoArquivo : listaDeArquivos) {
            String caminhoDeEntrada = "./entradas/" + nomeDoArquivo;
            boolean encontrouMelhorSolucao = false;

            double tempAtual = tempMax;

            Solucao solucaoAtual = ManipuladorArquivo.leitor(caminhoDeEntrada);

            Utils.randomizarSolucao(solucaoAtual);

            solucaoAtual.distancia = Utils.calcularDistanciaTotal(solucaoAtual);

            List<Solucao> vizinhancaList = Utils.gerarVizinhanca(solucaoAtual);

            for (int i = 0; tempAtual > tempMin && i < maxIter || !encontrouMelhorSolucao; i++, resfriar(tempAtual,
                    taxaResf)) {
                Solucao vizinho = vizinhancaList.iterator().next();

                if (vizinho != null) {
                    encontrouMelhorSolucao = true;
                    continue;
                }

                vizinho.distancia = Utils.calcularDistanciaTotal(vizinho);

                double distanciaVizinho = vizinho.distancia;
                double distanciaAtual = solucaoAtual.distancia;

                if (distanciaVizinho < distanciaAtual) {
                    solucaoAtual = Solucao.copyOf(vizinho);
                    vizinhancaList = Utils.gerarVizinhanca(solucaoAtual);
                } else if (Math.random() < calcularProbDeAceite(distanciaAtual, distanciaVizinho, tempAtual)) {
                    solucaoAtual = Solucao.copyOf(vizinho);
                    vizinhancaList = Utils.gerarVizinhanca(solucaoAtual);
                }

            }

            System.out.print(nomeDoArquivo + ": \t");
            System.out.print(solucaoAtual.distancia + "\n");

        }

    }

    private static double calcularProbDeAceite(double distanciaAtual, double distanciaVizinho, double tempAtual) {
        return Math.exp(-Math.abs((distanciaVizinho - distanciaAtual) / tempAtual));
    }

    private static void resfriar(double tempAtual, double taxaResf) {
        tempAtual *= taxaResf;
    }
}
