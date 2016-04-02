package GraphPack;

public class Edge {
    private int weight;
    private Vertex firstVertex;
    private Vertex secondVertex;

    public int getWeight() {
        return weight;
    }

    public Vertex getEndVertex(Vertex vert) {
        return vert == firstVertex ? secondVertex : firstVertex;
    }

    public boolean duplicate(Vertex v1, Vertex v2) {
        return ((v1 == firstVertex && v2 == secondVertex) || (v2 == firstVertex && v1 == secondVertex));
    }

    public Edge(int weight, Vertex firstVertex, Vertex startVertex) {
        this.weight = weight;
        this.firstVertex = firstVertex;
        this.secondVertex = startVertex;
    }
}