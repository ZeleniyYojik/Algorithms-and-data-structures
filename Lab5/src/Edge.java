public class Edge {
    public Vertex from;
    public Vertex to;
    public boolean visited;
    public double w = 1;

    public Edge(Vertex from, Vertex to) {
        this.from = from;
        this.to = to;
    }
}