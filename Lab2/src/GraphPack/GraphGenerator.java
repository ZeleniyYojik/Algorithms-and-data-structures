package GraphPack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//гарантируется связность, не гарантируется то, что из любой вершины можно попасть в любую другую
public class GraphGenerator {
    public Graph generateGraph(int vertexesCount, int edgesCount, int minWeight, int maxWeight) {
        /*максимальное количество ребер - перестановка сочетание n элементов по 2
            n!/(2!*(n-2)!) и *2 т.к. граф направленный
          минимальное количество ребер для связности n-1
        */
        if ((edgesCount > (vertexesCount * (vertexesCount - 1)))/*||(edgesCount<((vertexesCount-2)))*/) {
            System.out.print("Невозможно сгенерировать граф");
            return null;
        }
        Graph graph = new Graph();
        Random random = new Random();
        List<Vertex> inGraph = new ArrayList<>();
        for (int i = 0; i < vertexesCount; i++) {
            inGraph.add(new Vertex());
        }
        while (edgesCount > 0) {
            Vertex from = inGraph.get((random.nextInt(inGraph.size())));
            Vertex to = inGraph.get((random.nextInt(inGraph.size())));
            if (from != to) {
                if (!from.duplicateEdge(to)) {
                    from.getOutgoingEdges().add(new Edge(random.nextInt((maxWeight - minWeight) + minWeight), to, from));
                    edgesCount--;
                }
            }
        }
        graph.setVertexes(inGraph);
        return graph;
    }
}
