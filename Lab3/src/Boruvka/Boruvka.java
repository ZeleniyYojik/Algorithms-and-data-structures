package Boruvka;

import GraphPack.Edge;
import GraphPack.Graph;
import GraphPack.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Boruvka {
    public static long boruvka(Graph graph, Graph minTree, List<Edge> result) {
        long timeout = System.currentTimeMillis();
        minTree.setVertexes(new ArrayList<>());
        for (int i = 0; i < graph.getVertexes().size(); i++) {
            minTree.getVertexes().add(new Vertex(i));
        }
        while (result.size() < graph.getVertexes().size() - 1) {
            Vertex to = null;
            Vertex from = null;
            List<Comp> comps = Graph.dfs(minTree);
            for (Comp comp : comps) {
                for (Vertex vert : comp.vertexes) {
                    Vertex v = graph.getVertexes().get(vert.index);
                    for (Edge edge : v.getIncidentEdges()) {
                        if (edge.getWeight() < comp.minWeight && minTree.getVertexes().get(edge.getEndVertex(graph.getVertexes().get(vert.index)).index).comp != comp) {
                            comp.minEdge = edge;
                            comp.minWeight = edge.getWeight();
                            from = graph.getVertexes().get(vert.index);
                            to = edge.getEndVertex(from);
                        }
                    }
                }
                if (!result.contains(comp.minEdge)) {
                    result.add(comp.minEdge);
                    Vertex f = minTree.getVertexes().get(from.index);
                    Vertex s = minTree.getVertexes().get(to.index);
                    Edge edge = new Edge(comp.minEdge.getWeight(), f, s);
                    minTree.getVertexes().get(from.index).getIncidentEdges().add(edge);
                    minTree.getVertexes().get(to.index).getIncidentEdges().add(edge);
                }
            }
        }
        return (System.currentTimeMillis() - timeout);
    }
}
