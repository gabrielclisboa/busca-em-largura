import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class Main
{
    public static void main(String args[]) throws FileNotFoundException {
        //Declaração de variáveis
        Grafo g = new Grafo();
        String verticeSelecionado = new String();
        Scanner read = new Scanner(System.in);

        //Lê arquivo e preenche grafo
        Scanner in = new Scanner(new FileReader("vertices.txt"));
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String vertices[] = line.split(",");
            g.addVerticeAdjacente(vertices[0],vertices[1]);
        }


        //Seleciona o vétice raiz
        System.out.println("Digite vértice raiz para a busca em largura:");
        verticeSelecionado = read.next();

        System.out.println("Vértices visitados na busca em largura, a partir do vértice: " + verticeSelecionado);
        g.buscaLargura(verticeSelecionado);
    }
}