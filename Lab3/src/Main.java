import GraphPack.Graph;
import GraphPack.GraphGenerator;
import Prima.PrimaBinaryHeap;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        GraphGenerator graphGenerator = new GraphGenerator();
        Graph graphPrima = graphGenerator.generateGraphForPrima(5,10,1,10);
        PrimaBinaryHeap.prima(graphPrima,2,new ArrayList<>());
    }
}
