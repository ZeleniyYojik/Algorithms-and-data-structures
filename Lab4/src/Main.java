//Lab4 Pashnin A.D. Variant 6
public class Main {
    public static void main(String args[]) {
        Graph graph = new Graph();
        int d;
        do {
            graph.seUnvisited();
            d = FordFulkerson.ford_fulkerson(graph.vertices.get(0), Integer.MAX_VALUE, graph);
        } while (d != 0);
        Printer.print(graph);
    }
}
