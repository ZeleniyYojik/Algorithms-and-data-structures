package Boruvka;

import GraphPack.Edge;
import GraphPack.Graph;
import GraphPack.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Boruvka {
    public static long boruvka(Graph graph, Graph minTree, List<Edge> result) {
        long timeout = System.currentTimeMillis();
        List<Vertex> tree = new ArrayList<>();
        for (int i = 0; i < graph.getVertexes().size(); i++) {
            tree.add(new Vertex(i));
        }
        minTree.setVertexes(tree);
        while (result.size() < graph.getVertexes().size() - 1) {
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
                if (!result.contains(comp.minEdge)) {
                    result.add(comp.minEdge);
                }
                Edge edge = new Edge(comp.minEdge.getWeight(), tree.get(ind), tree.get(comp.minEdge.getEndVertex(graph.getVertexes().get(ind)).index));
                tree.get(ind).getIncidentEdges().add(edge);
                tree.get(comp.minEdge.getEndVertex(graph.getVertexes().get(ind)).index).getIncidentEdges().add(edge);
            }
        }
        return (System.currentTimeMillis() - timeout);
    }
}
