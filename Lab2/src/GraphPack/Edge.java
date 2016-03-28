package GraphPack;

public class Edge {
    private int weight;
    private Vertex endVertex;
    private Vertex startVertex;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(Vertex endVertex) {
        this.endVertex = endVertex;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Edge(int weight, Vertex endVertex, Vertex startVertex) {
        this.weight = weight;
        this.endVertex = endVertex;
        this.startVertex = startVertex;
    }
}