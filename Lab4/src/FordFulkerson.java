import java.util.ArrayList;
import java.util.List;

public class FordFulkerson {
    public static int ford_fulkerson(Vertex u, int Cmin, Graph graph) {
        if (u == graph.t) {
            return Cmin;
        }
        u.visited = true;
        for (Edge e : u.edges) {
            Vertex v = e.getEndVert(u);
            boolean d = e.to == v;
            if (!v.visited && ((d && e.f < e.c) || (!d && e.f > 0 && e.f < e.c))) {
                int delta = ford_fulkerson(v, min(Cmin, e.c - e.f), graph);
                if (delta > 0) {
                    if (d) {
                        e.f += delta;
                        if (e.backEdge != null) {
                            e.backEdge.f -= delta;
                        }
                    } else {
                        e.f -= delta;
                        if (e.backEdge != null) {
                            e.backEdge.f += delta;
                        }
                    }
                    return delta;
                }
            }
        }
        return 0;
    }

    public static List<Vertex> min_cut(Graph graph) {
        List<Vertex> cut = new ArrayList<>();
        cut.add(graph.s);
        int i = -1;
        while (i != cut.size() - 1) {
            i++;
            Vertex v = cut.get(i);
            v.edges.stream().filter(e -> !cut.contains(e.to)).filter(e -> e.f - e.c != 0).forEach(e -> {
                cut.add(e.to);
            });
        }
        return cut;
    }

    static int min(int a, int b) {
        return a <= b ? a : b;
    }
}
