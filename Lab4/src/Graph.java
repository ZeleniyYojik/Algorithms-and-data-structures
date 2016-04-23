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
        A.name = "A";
        B.name = "B";
        C.name = "C";
        D.name = "D";
        E.name = "E";
        F.name = "F";
        t = F;
        s = A;
        //Ванькин граф
//        Edge AB = new Edge(A, B, 5, "AB");
//        Edge AE = new Edge(A, E, 4, "AE");
//        Edge AC = new Edge(A, C, 2, "AC");
//        A.edges.add(AB);
//        A.edges.add(AE);
//        A.edges.add(AC);
//        Edge BC = new Edge(B, C, 7, "BC");
//        Edge BD = new Edge(B, D, 6, "BD");
//        Edge CB = new Edge(C, B, 7, "CB");
//        Edge DB = new Edge(C, B, 6, "DB");
//        BC.backEdge = CB;
//        CB.backEdge = BC;
//        BD.backEdge = DB;
//        DB.backEdge = BD;
//        B.edges.add(BC);
//        C.edges.add(BC);
//        B.edges.add(CB);
//        C.edges.add(CB);
//        B.edges.add(BD);
//        D.edges.add(BD);
//        B.edges.add(DB);
//        D.edges.add(DB);
//
//        Edge BE = new Edge(B, E, 3, "BE");
//        Edge EB = new Edge(E, B, 3, "EB");
//        BE.backEdge = EB;
//        EB.backEdge = BE;
//        B.edges.add(BE);
//        B.edges.add(EB);
//        E.edges.add(EB);
//        E.edges.add(BE);
//        Edge CE = new Edge(C, E, 4, "CE");
//        Edge EC = new Edge(E, C, 4, "EC");
//        CE.backEdge = EC;
//        EC.backEdge = CE;
//        C.edges.add(CE);
//        C.edges.add(EC);
//        E.edges.add(EC);
//        E.edges.add(CE);
//        Edge ED = new Edge(E, D, 3, "ED");
//        Edge DE = new Edge(D, E, 3, "DE");
//        ED.backEdge = DE;
//        DE.backEdge = ED;
//        E.edges.add(ED);
//        E.edges.add(DE);
//        D.edges.add(DE);
//        D.edges.add(ED);
//        Edge DF = new Edge(D, F, 5, "DF");
//        Edge EF = new Edge(E, F, 6, "EF");
//        D.edges.add(DF);
//        E.edges.add(EF);
        //
        //Пример 2 из теории
//        Edge AB = new Edge(A, B, 9, "AB");
//        AB.f = 6;
//        Edge AC = new Edge(A, C, 8, "AC");
//        AC.f = 3;
//        A.edges.add(AB);
//        A.edges.add(AC);
//        Edge BD = new Edge(B, D, 6, "BD");
//        BD.f = 3;
//        Edge BE = new Edge(B, E, 3, "BE");
//        BE.f = 3;
//        B.edges.add(BD);
//        D.edges.add(BD);
//        B.edges.add(BE);
//        E.edges.add(BE);
//        Edge ED = new Edge(E, D, 4, "ED");
//        ED.f = 2;
//        E.edges.add(ED);
//        D.edges.add(ED);
//        Edge DF = new Edge(D, F, 10, "DF");
//        DF.f = 5;
//        D.edges.add(DF);
//        Edge EF = new Edge(E, F, 7, "EF");
//        EF.f = 4;
//        E.edges.add(EF);
        //
        //Мой граф
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
        C.edges.add(BC);
        B.edges.add(CB);
        C.edges.add(CB);
        Edge BE = new Edge(B, E, 20, "BE");
        Edge EB = new Edge(E, B, 20, "EB");
        BE.backEdge = EB;
        EB.backEdge = BE;
        B.edges.add(BE);
        B.edges.add(EB);
        E.edges.add(EB);
        E.edges.add(BE);
        Edge CE = new Edge(C, E, 8, "CE");
        Edge EC = new Edge(E, C, 8, "EC");
        CE.backEdge = EC;
        EC.backEdge = CE;
        C.edges.add(CE);
        C.edges.add(EC);
        E.edges.add(EC);
        E.edges.add(CE);
        Edge ED = new Edge(E, D, 15, "ED");
        Edge DE = new Edge(D, E, 15, "DE");
        ED.backEdge = DE;
        DE.backEdge = ED;
        E.edges.add(ED);
        E.edges.add(DE);
        D.edges.add(DE);
        D.edges.add(ED);
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
