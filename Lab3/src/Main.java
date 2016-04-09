import Boruvka.Boruvka;
import GraphPack.Edge;
import GraphPack.Graph;
import GraphPack.GraphGenerator;
import GraphPack.Vertex;
import Prima.PrimaBinaryHeap;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        GraphGenerator graphGenerator = new GraphGenerator();
        Graph graph = graphGenerator.generateGraph(11, 20, 1, 10);
        System.out.println("Исходный");
        Printer.print(graph);
        List<Edge> prima = new ArrayList<>();
        System.out.println("Прима");
        PrimaBinaryHeap.prima(graph, 2, prima);
        Printer.print(prima);
        System.out.println("Борувка");
        Graph bor = new Graph();
        bor.setVertexes(new ArrayList<>());
        for (int i = 0; i < graph.getVertexes().size(); i++) {
            graph.getVertexes().get(i).index = i;
        }
        List<Edge> resBor = new ArrayList<>();
        Boruvka.boruvka(graph, bor, resBor);
        Printer.print(resBor);
        System.out.println();
    }
}
