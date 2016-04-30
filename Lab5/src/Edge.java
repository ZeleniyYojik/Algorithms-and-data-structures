public class Edge {
    public Vertex from;
    public Vertex to;
    public boolean visited;

    public Edge(Vertex from, Vertex to) {
        this.from = from;
        this.to = to;
    }
}