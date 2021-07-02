import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManipuladorArquivo {

    public static Solucao leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        List<Cidade> listaDeCidades = new ArrayList<>();

        linha = buffRead.readLine();

        do {

            if (linha == "" || linha == "\n") {
                linha = null;
            } else {

                String[] linhaList = linha.strip().split(" ");
                double[] coords = new double[3];
                int j = 0;

                for (int i = 0; i < linhaList.length; i++) {

                    linhaList[i] = linhaList[i].strip();

                    if (linhaList[i] != "" && linhaList[i] != "\n" && linhaList[i] != " ") {
                        coords[j] = Double.parseDouble(linhaList[i]);
                        j++;
                    }
                }
                listaDeCidades.add(new Cidade(coords[1], coords[2]));
            }

            linha = buffRead.readLine();
            // System.out.println(linha);

        } while (linha != null);

        // for (Cidade cidade : listaDeCidades) {
        // System.out.println(cidade.toString());
        // }

        buffRead.close();
        return new Solucao(listaDeCidades);
    }

    public static void escritor(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Escreva algo: ");
        // TODO: Adaptar para escrever a saída esperada e não oq for digitado
        linha = in.nextLine();
        buffWrite.append(linha + "\n");
        buffWrite.close();
    }

    public static void escreverArquivoPelaMatriz(String path, int[][] matriz) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = "";

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                linha += String.valueOf(matriz[i][j]) + " ";

                // System.out.println("Linha " + i + " coluna " + j + ": " + linha);
            }
            buffWrite.append(linha + "\n");
            linha = "";
        }

        buffWrite.close();
    }

    public static void escreverArquivoPelaLista(String path, List<Integer> lista) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = "";

        for (int i = 0; i < lista.size(); i++, linha = "") {

            linha = lista.get(i).toString();

            buffWrite.append(linha + "\n");
        }

        buffWrite.close();
    }

}
