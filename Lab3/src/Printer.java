import GraphPack.Edge;
import GraphPack.Graph;
import GraphPack.Vertex;

import java.util.List;

public class Printer {
    public static void print(Graph graph) {
        for (Vertex v : graph.getVertexes()) {
            for (Edge edge : v.getIncidentEdges()) {
                System.out.print(v.index + " -> " + edge.getEndVertex(v).index + "   W: " + edge.getWeight());
                System.out.println();
            }
        }
    }

    public static void print(List<Edge> edges) {
        int sum = 0;
        for (Edge e : edges) {
            System.out.print(e.getFirstVertex().index + " -> " + e.getSecondVertex().index + "   W: " + e.getWeight());
            sum += e.getWeight();
            System.out.println();
        }
        System.out.println("Sum: " + sum);
    }
}
