import Boruvka.Boruvka;
import GraphPack.Edge;
import GraphPack.Graph;
import GraphPack.GraphGenerator;
import Prima.PrimaBinaryHeap;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        GraphGenerator graphGenerator = new GraphGenerator();
        Graph graph = graphGenerator.generateGraphForPrima(5, 10, 1, 10);
        List<Edge> prima = new ArrayList<>();
        PrimaBinaryHeap.prima(graph, 2, prima);
        Graph bor = new Graph();
        bor.setVertexes(new ArrayList<>());
        Boruvka.boruvka(graph, bor);
        System.out.println();
    }
}
