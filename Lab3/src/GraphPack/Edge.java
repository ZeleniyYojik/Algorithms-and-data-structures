package GraphPack;

public class Edge {
    private int weight;
    private Vertex firstVertex;
    private Vertex secondVertex;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getEndVertex(Vertex vert) {
        return vert == firstVertex ? secondVertex : firstVertex;
    }

    public void setFirstVertex(Vertex firstVertex) {
        this.firstVertex = firstVertex;
    }

    public Vertex getSecondVertex() {
        return secondVertex;
    }

    public void setSecondVertex(Vertex secondVertex) {
        this.secondVertex = secondVertex;
    }

    public Edge(int weight, Vertex firstVertex, Vertex startVertex) {
        this.weight = weight;
        this.firstVertex = firstVertex;
        this.secondVertex = startVertex;
    }
}