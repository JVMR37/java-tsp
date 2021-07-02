import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hill {
    public static void main(String[] args) throws IOException {

        gerarRelatorio();

    }

    private static double calcularDistanciaTotal(Solucao solucao) {
        int i = 0;
        double distanciaTotal = 0;

        double radicando1 = solucao.caminho.get(0).x - solucao.caminho.get(solucao.caminho.size() - 1).x;
        double radicando2 = solucao.caminho.get(0).y - solucao.caminho.get(solucao.caminho.size() - 1).y;
        radicando1 = Math.pow(radicando1, 2);
        radicando2 = Math.pow(radicando2, 2);
        distanciaTotal += Math.sqrt(radicando1 + radicando2);

        while (i < solucao.caminho.size() - 1) {
            radicando1 = solucao.caminho.get(i).x - solucao.caminho.get(i + 1).x;
            radicando2 = solucao.caminho.get(i).y - solucao.caminho.get(i + 1).y;
            radicando1 = Math.pow(radicando1, 2);
            radicando2 = Math.pow(radicando2, 2);
            distanciaTotal += Math.sqrt(radicando1 + radicando2);
            i++;
        }

        return distanciaTotal;
    }

    private static void randomizarSolucao(Solucao solucao) {
        Collections.shuffle(solucao.caminho);
    }

    private static List<Solucao> gerarVizinhanca(Solucao solucao) {
        List<Solucao> vizinhanca = new ArrayList<>();

        for (int i = 0; i < solucao.caminho.size(); i++) {
            for (int j = i + 1; j < solucao.caminho.size(); j++) {
                Solucao vizinho = new Solucao();
                List<Cidade> caminho = new ArrayList<>(solucao.caminho);

                caminho.set(i, solucao.caminho.get(j));

                caminho.set(j, solucao.caminho.get(i));

                vizinho.caminho = caminho;

                vizinho.distancia = calcularDistanciaTotal(vizinho);

                vizinhanca.add(vizinho);
            }

        }

        return vizinhanca;
    }

    private static Solucao buscarMelhorVizinho(List<Solucao> vizinhanca) {
        Solucao melhorVizinho = new Solucao();
        double melhorDistancia = Double.MAX_VALUE;

        for (Solucao solucao : vizinhanca) {
            double distanciaAtual = calcularDistanciaTotal(solucao);

            if (distanciaAtual < melhorDistancia) {
                melhorDistancia = distanciaAtual;
                melhorVizinho = solucao;
            }
        }

        return melhorVizinho;

    }

    private static void gerarRelatorio() throws IOException {
        String[] listaDeArquivos = { "att48.tsp.txt", "berlin52.tsp.txt", "bier127.tsp.txt", "eil101.tsp.txt",
                "eil76.tsp.txt", "kroA100.tsp.txt", "kroE100.tsp.txt", "pr76.tsp.txt", "rat99.tsp.txt",
                "st70.tsp.txt" };

        for (String nomeDoArquivo : listaDeArquivos) {
            String caminhoDeEntrada = "./entradas/" + nomeDoArquivo;

            Solucao solucao = ManipuladorArquivo.leitor(caminhoDeEntrada);

            randomizarSolucao(solucao);

            solucao.distancia = calcularDistanciaTotal(solucao);

            List<Solucao> vizinhancaList = gerarVizinhanca(solucao);

            Solucao melhorVizinho = buscarMelhorVizinho(vizinhancaList);

            while (melhorVizinho.distancia < solucao.distancia) {
                solucao = melhorVizinho;

                vizinhancaList = gerarVizinhanca(solucao);

                melhorVizinho = buscarMelhorVizinho(vizinhancaList);

            }

            System.out.print(nomeDoArquivo + ": \t");
            System.out.print(solucao.distancia + "\n");

        }

    }
}
