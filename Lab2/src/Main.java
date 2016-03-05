import Dijkstra.DijkstraBinaryHeap;
import GraphPack.Graph;
import GraphPack.GraphGenerator;

public class Main {
    public static void main(String[] args) {
        GraphGenerator graphGenerator = new GraphGenerator();
        Graph graph = graphGenerator.generateGraph(10001, 100000, 1, 1000000);
        System.out.print(DijkstraBinaryHeap.dijkstra(graph,0));
    }
}
