import java.util.List;

public class Printer {
    public static void print(Graph graph) {
        graph.vertices.stream().forEach(vertex -> vertex.edges.forEach(e -> System.out.println(e.name + "  " + e.c + "/" + e.f)));
    }

    public static void print(List<Vertex> cut) {
        cut.stream().forEach(vertex -> System.out.println(vertex.name));
    }
}
