public class Edge {
    public Vertex from;
    public Vertex to;
    public int c;
    public int f = 0;
    public String name;//Для вывода на экран
    public Edge backEdge = null;

    public Edge(Vertex from, Vertex to, int c, String name) {
        this.from = from;
        this.to = to;
        this.c = c;
        this.name = name;
    }

    public Vertex getEndVert(Vertex u) {
        return u == from ? to : from;
    }
}
