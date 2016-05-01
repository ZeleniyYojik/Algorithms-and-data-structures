import java.util.ArrayList;
import java.util.List;

public class Vertex {
    public List<Edge> edges = new ArrayList<>();
    public int numb;
    public Vertex prev;
    public double dist;
    public boolean visited;

    public Vertex(int i) {
        this.numb = i;
    }

    public void setEdgeVisited() {
        if (this.prev == null) {
            return;
        }
        this.prev.edges.stream().forEach(edge -> {
            if (edge.to == this) {
                edge.visited = true;
            }
        });
    }
}