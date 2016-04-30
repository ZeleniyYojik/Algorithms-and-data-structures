import java.util.ArrayList;
import java.util.List;

public class Vertex {
    public List<Edge> edges = new ArrayList<>();
    public int numb;

    public Vertex(int i) {
        this.numb = i;
    }
}