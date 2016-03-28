package DijkstraMarks;

import GraphPack.Graph;
import GraphPack.Vertex;

public class DijkstraWithMarks {
    public static long dijkstraWithMarks(Graph graph, int s) {
        long timeout = System.currentTimeMillis();
        for (int i = 0; i < graph.getVertexes().size(); i++) {
            Vertex vertex = graph.getVertexes().get(i);
            vertex.dist = Double.POSITIVE_INFINITY;
            vertex.visited = false;
        }
        graph.getVertexes().get(s).dist = 0;
        int count = graph.getVertexes().size();
        while (count > 0) {
            int c = 0;
            while (graph.getVertexes().get(c).visited) {
                c++;
            }
            int i = c;
            for (int k = c + 1; k < count; k++) {
                if (!graph.getVertexes().get(k).visited) {
                    if (graph.getVertexes().get(i).dist > graph.getVertexes().get(k).dist) {
                        i = k;
                    }
                }
            }
            Vertex current = graph.getVertexes().get(i);
            current.visited = true;
            count--;
            for (int k = 0; k < current.getOutgoingEdges().size(); k++) {
                Vertex next = current.getOutgoingEdges().get(k).getEndVertex();
                if (!next.visited) {
                    if (next.dist > current.dist + current.getOutgoingEdges().get(k).getWeight()) {
                        next.dist = current.dist + current.getOutgoingEdges().get(k).getWeight();
                        next.previous = current;
                    }
                }
            }

        }
        return (System.currentTimeMillis() - timeout);
    }
}
