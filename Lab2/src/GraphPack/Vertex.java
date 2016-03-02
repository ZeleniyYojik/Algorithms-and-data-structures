package GraphPack;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private List<Edge> outgoingEdges = new ArrayList<>();
    public int key;

    public List<Edge> getOutgoingEdges() {
        return outgoingEdges;
    }

    public void setOutgoingEdges(List<Edge> outgoingEdges) {
        this.outgoingEdges = outgoingEdges;
    }

    public boolean duplicateEdge(Vertex vertex) {
        for (Edge edge : outgoingEdges) {
            if (edge.getEndVertex() == vertex) {
                return true;
            }
        }
        return false;
    }
}