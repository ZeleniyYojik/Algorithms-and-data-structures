public class FordFulkerson {
    public static int ford_fulkerson(Vertex u, int Cmin, Graph graph) {
        if (u == graph.t) {
            return Cmin;
        }
        u.visited = true;
        for (Edge e : u.edges) {
            Vertex v = e.getEndVert();
            if (!v.visited && e.f < e.c) {
                int delta = ford_fulkerson(v, min(Cmin, e.c - e.f), graph);
                if (delta > 0) {
                    e.f += delta;
                    if (e.backEdge != null) {
                        e.backEdge.f -= delta;
                    }
                    return delta;
                }
            }
        }
        return 0;
    }

    static int min(int a, int b) {
        return a <= b ? a : b;
    }
}
