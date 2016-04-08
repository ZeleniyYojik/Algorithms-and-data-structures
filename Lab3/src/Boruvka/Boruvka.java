package Boruvka;

import GraphPack.Edge;
import GraphPack.Graph;
import GraphPack.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Boruvka {
    public static long boruvka(Graph graph, Graph minTree) {
        long timeout = System.currentTimeMillis();
        List<Vertex> tree = new ArrayList<>();
        for (int i = 0; i < graph.getVertexes().size(); i++) {
            tree.add(new Vertex(i));
        }
        minTree.setVertexes(tree);
        int size = 0;
        while (size < graph.getVertexes().size() - 1) {
            int ind = 0;
            List<Comp> comps = Graph.dfs(minTree);
            for (Comp comp : comps) {
                for (Vertex vert : comp.vertexes) {
                    for (Edge edge : graph.getVertexes().get(vert.index).getIncidentEdges()) {
                        if (edge.getWeight() < comp.minWeight && edge.getEndVertex(vert).comp != comp) {
                            comp.minEdge = edge;
                            comp.minWeight = edge.getWeight();
                            ind = vert.index;
                        }
                    }
                }
                tree.get(ind).getIncidentEdges().add(comp.minEdge);
                size++;
            }
        }
        return (System.currentTimeMillis() - timeout);
    }
}
