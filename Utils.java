import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {
    public static double calcularDistanciaTotal(Solucao solucao) {
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

    public static void randomizarSolucao(Solucao solucao) {
        Collections.shuffle(solucao.caminho);
    }

    public static List<Solucao> gerarVizinhanca(Solucao solucao) {
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

    public static Solucao buscarMelhorVizinho(List<Solucao> vizinhanca) {
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
}
