public class Printer {
    public static void print(Graph graph) {
        for (Vertex v : graph.vertices) {
            for (Edge e : v.edges) {
                System.out.println(e.name + "  " + e.c + "/" + e.f);
            }
        }
    }
}
