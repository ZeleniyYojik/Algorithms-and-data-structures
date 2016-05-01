public class Dijkstra {
    public static void dijkstra(Graph graph, int s) {
        for (int i = 0; i < graph.vertices.length; i++) {
            Vertex vertex = graph.vertices[i];
            vertex.dist = Double.POSITIVE_INFINITY;
            vertex.visited = false;
            vertex.prev = null;
        }
        graph.vertices[s].dist = 0;
        int count = graph.vertices.length;
        while (count > 0) {
            int c = 0;
            while (graph.vertices[c].visited) {
                c++;
            }
            int i = c;
            for (int k = c + 1; k < count; k++) {
                if (!graph.vertices[k].visited) {
                    if (graph.vertices[i].dist > graph.vertices[k].dist) {
                        i = k;
                    }
                }
            }
            Vertex current = graph.vertices[i];
            current.visited = true;
            count--;
            for (int k = 0; k < current.edges.size(); k++) {
                Edge e = current.edges.get(k);
                if (!e.visited) {
                    Vertex next = e.to;
                    if (!next.visited) {
                        if (next.dist > current.dist + current.edges.get(k).w) {
                            next.dist = current.dist + current.edges.get(k).w;
                            next.prev = current;
                        }
                    }
                }
            }
        }
    }
}