package GraphPack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphGenerator {
    public Graph generateGraph(int vertexesCount, int edgesCount, int minWeight, int maxWeight) {
        Graph graph = new Graph();
        Random random = new Random();
        List<Vertex> inGraph = new ArrayList<>();
        List<Vertex> notInGraph = new ArrayList<>();
        for (int i = 0; i < vertexesCount; i++) {
            notInGraph.add(new Vertex());
        }
        while (edgesCount > 0) {
            Vertex from = inGraph.get((random.nextInt(inGraph.size())));
            Vertex to = inGraph.get((random.nextInt(inGraph.size())));
            if (from != to) {
                if (!from.duplicateEdge(from, to)) {
                    from.getIncidentEdges().add(new Edge(random.nextInt((maxWeight - minWeight) + minWeight), to, from));
                    edgesCount--;
                }
            }
        }
        graph.setVertexes(inGraph);
        return graph;
    }
}
