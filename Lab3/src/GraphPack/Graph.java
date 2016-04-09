package GraphPack;

import Boruvka.Comp;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> vertexes;

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public void setVertexes(List<Vertex> vertexes) {
        this.vertexes = vertexes;
    }

    public static List<Comp> dfs(Graph minTree) {
        for (Vertex vert : minTree.getVertexes()) {
            vert.comp = null;
        }
        List<Comp> result = new ArrayList<>();
        minTree.getVertexes().stream().filter(vert -> vert.comp == null).forEach(vert -> {
            Comp comp = new Comp();
            dfs(vert, comp);
            result.add(comp);
        });
        return result;
    }

    private static void dfs(Vertex vert, Comp comp) {
        if (vert.comp == null) {
            vert.comp = comp;
            comp.vertexes.add(vert);
            for (Edge edge : vert.getIncidentEdges()) {
                dfs(edge.getEndVertex(vert), comp);
            }
        }
    }
}
