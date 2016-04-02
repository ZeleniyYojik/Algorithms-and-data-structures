package GraphPack;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private List<Edge> incidentEdges = new ArrayList<>();
    public double key;
    public int heapIndex;

    public List<Edge> getIncidentEdges() {
        return incidentEdges;
    }


    public boolean duplicateEdge(Vertex vertex1, Vertex vertex2) {
        for (Edge edge:incidentEdges){
            if (edge.duplicate(vertex1,vertex2)){
                return true;
            }
        }
        return false;
    }
}