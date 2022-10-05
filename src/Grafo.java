import java.util.*;
public class Grafo {

    private Map<String, List<String>> grafo;

    Grafo()
    {
        grafo = new HashMap<String, List<String>>();
    }

    /*
     * Acrescenta vétices na lista de adjacência
     *
     * @param  v  vértice
     * @param  w  vértice adjacênte a v
     */
    void addVerticeAdjacente(String v, String w)
    {
        if(grafo.get(v) != null){
            List<String> vertices = grafo.get(v);
            vertices.add(w);
            grafo.put(v,vertices);
        }else {
            List<String> vertices = new ArrayList<String>();
            vertices.add(w);
            grafo.put(v,vertices);
        }
    }

    /*
     * Realiza a busca em largura.
     *
     * @param  vertice  é o vértice referência para iniciar a busca em largura
     */
    void buscaLargura(String vertice)
    {
        Map<String,Boolean> vertices  = new HashMap<String, Boolean>();

        for (Map.Entry<String, List<String>> g : grafo.entrySet()) {
            vertices.put(g.getKey(),false);
        }

        //Lista de vértices que vão ter seus "filhos" visitados
        LinkedList<String> queue = new LinkedList<String>();

        //O vértice raiz é considerado como visitado por padrão e é adicionado na lista de vértices visitados
        vertices.put(vertice,true);

        queue.add(vertice);

        while (queue.size() != 0)
        {
            // Atribui o número do vértice "head" da lista e lhe exclui da lista logo em seguida.
            vertice = queue.poll();
            System.out.print(vertice +" ");

            // Pega todos os vértices adjacentes de s
            // Se um desses vértices não foi visitado ainda, ele será marcado e adicionado na lista queue
            List<String> i = grafo.get(vertice);

            i.forEach(
                    nomeVertice->{
                        for (Map.Entry<String, Boolean> v : vertices.entrySet()) {
                            if(v.getKey().equals(nomeVertice) && v.getValue().equals(false)){
                                v.setValue(true);
                                queue.add(v.getKey());
                            }
                        }
                    }
            );

        }
        System.out.println();

        for (Map.Entry<String, List<String>> entry : grafo.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }

}
