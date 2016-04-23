import java.util.List;

//Lab4 Pashnin A.D. Variant 6
public class Main {
    public static void main(String args[]) {
        Graph graph = new Graph();
        int d;
        do {
            graph.seUnvisited();
            d = FordFulkerson.ford_fulkerson(graph.vertices.get(0), Integer.MAX_VALUE, graph);
        } while (d != 0);
        System.out.println("Ребра графа");
        Printer.print(graph);
        System.out.println("Вершины минимального разреза");
        List<Vertex> cut = FordFulkerson.min_cut_vertexes(graph);
        Printer.print_vcut(cut);
        System.out.println("Ребра минимального разреза");
        List<Edge> ecut = FordFulkerson.min_cut_edges(graph);
        Printer.print_ecut(ecut);
        System.out.println("Поток через минимальный разрез");
        int f = 0;
        for (Edge e : ecut) {
            f += e.f;
        }
        System.out.println(f);
        System.out.println("Максимальный поток");
        f = 0;
        for (Edge e : graph.s.edges) {
            f += e.f;
        }
        System.out.println(f);
    }
}
