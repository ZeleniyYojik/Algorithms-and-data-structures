package Dijkstra;

import GraphPack.Graph;
import GraphPack.Vertex;


public class DijkstraBinaryHeap {
    public static long dijkstra(Graph graph, int s) {
        long timeout = System.currentTimeMillis();
        BinaryHeap heap = new BinaryHeap();
        for (int i = 0; i < graph.getVertexes().size(); i++) {
            Vertex vert = graph.getVertexes().get(i);
            vert.key = Double.POSITIVE_INFINITY;
            vert.dist = Double.POSITIVE_INFINITY;
            if (i == s) {
                vert.key = 0;
            }
            heap.add(vert);
        }
        while (heap.getKeys().size() > 0) {
            Vertex vertex = heap.extractMin();
            vertex.dist = vertex.key;
            for (int i = 0; i < vertex.getOutgoingEdges().size(); i++) {
                Vertex next = vertex.getOutgoingEdges().get(i).getEndVertex();
                if (next.key > vertex.dist + vertex.getOutgoingEdges().get(i).getWeight()) {
                    next.key = vertex.dist + vertex.getOutgoingEdges().get(i).getWeight();
                    next.previous = vertex;
                    heap.siftUp(next.heapIndex);
                }
            }
        }
        return (System.currentTimeMillis()-timeout);
    }
}
