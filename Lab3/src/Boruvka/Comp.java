package Boruvka;

import GraphPack.Edge;
import GraphPack.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Comp {
    public List<Vertex> vertexes = new ArrayList<>();
    Edge minEdge;
    int minWeight = Integer.MAX_VALUE;
    Vertex endVertex;
}
