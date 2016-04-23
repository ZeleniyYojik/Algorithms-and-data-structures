import java.util.ArrayList;
import java.util.List;

public class Graph {
    public List<Vertex> vertices = new ArrayList<>();
    public Vertex t;
    public Vertex s;

    public Graph() {
        init();
    }

    private void init() {
        for (int i = 0; i < 6; i++) {
            vertices.add(new Vertex());
        }
        Vertex A = vertices.get(0);
        Vertex B = vertices.get(1);
        Vertex C = vertices.get(2);
        Vertex D = vertices.get(3);
        Vertex E = vertices.get(4);
        Vertex F = vertices.get(5);
        t = F;
        s = A;
        Edge AB = new Edge(A, B, 14, "AB");
        Edge AD = new Edge(A, D, 10, "AD");
        Edge AC = new Edge(A, C, 2, "AC");
        A.edges.add(AB);
        A.edges.add(AD);
        A.edges.add(AC);
        Edge BC = new Edge(B, C, 5, "BC");
        Edge CB = new Edge(C, B, 5, "CB");
        BC.backEdge = CB;
        CB.backEdge = BC;
        B.edges.add(BC);
        C.edges.add(CB);
        Edge BE = new Edge(B, E, 20, "BE");
        Edge EB = new Edge(E, B, 20, "EB");
        BE.backEdge = EB;
        EB.backEdge = BE;
        B.edges.add(BE);
        E.edges.add(EB);
        Edge CE = new Edge(C, E, 8, "CE");
        Edge EC = new Edge(E, C, 8, "EC");
        CE.backEdge = EC;
        EC.backEdge = CE;
        C.edges.add(CE);
        E.edges.add(EC);
        Edge ED = new Edge(E, D, 15, "ED");
        Edge DE = new Edge(D, E, 15, "DE");
        ED.backEdge = DE;
        DE.backEdge = ED;
        E.edges.add(ED);
        D.edges.add(DE);
        Edge DF = new Edge(D, F, 21, "DF");
        Edge EF = new Edge(E, F, 10, "EF");
        D.edges.add(DF);
        E.edges.add(EF);
    }

    public void seUnvisited() {
        for (Vertex v : vertices) {
            v.visited = false;
        }
    }
}
