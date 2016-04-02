package Prima;

import GraphPack.Edge;
import GraphPack.Graph;
import GraphPack.Vertex;

import java.util.List;


public class PrimaBinaryHeap {
    public static long prima(Graph graph, int s, List<Edge> minTree) {
        long timeout = System.currentTimeMillis();
        minTree.clear();
        BinaryHeap heap = new BinaryHeap();
        for (int i = 0; i < graph.getVertexes().size(); i++) {
            Vertex vert = graph.getVertexes().get(i);
            vert.key = Double.POSITIVE_INFINITY;
            if (i == s) {
                vert.key = 0;
            }
            heap.add(vert);
        }
        while (heap.getKeys().size() > 0) {
            Vertex vertex = heap.extractMin();
            for (int i = 0; i < vertex.getIncidentEdges().size(); i++) {
                Vertex next = vertex.getIncidentEdges().get(i).getEndVertex(vertex);
                if (next.key > vertex.getIncidentEdges().get(i).getWeight()) {
                    removeFromTree(next, minTree);
                    next.key = vertex.getIncidentEdges().get(i).getWeight();
                    minTree.add(vertex.getIncidentEdges().get(i));
                    heap.siftUp(next.heapIndex);
                }
            }
        }
        return (System.currentTimeMillis() - timeout);
    }

    static void removeFromTree(Vertex vert, List<Edge> minTree) {
        for (Edge edge : vert.getIncidentEdges()) {
            if (minTree.contains(edge) && edge.getWeight() == vert.key){
                minTree.remove(edge);
                return;
            }
        }
    }
}
