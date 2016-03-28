import Dijkstra.DijkstraBinaryHeap;
import DijkstraMarks.DijkstraWithMarks;
import GraphPack.Graph;
import GraphPack.GraphGenerator;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try (
                OutputStream ous = new FileOutputStream("output5.csv");
                OutputStreamWriter ouw = new OutputStreamWriter(ous, Charset.forName("UTF-8"));
                BufferedWriter bw = new BufferedWriter(ouw)
        ) {
            GraphGenerator graphGenerator = new GraphGenerator();
            StringBuilder sb = new StringBuilder();
//            sb.append("Количество вершин;Дейкстры на 2-куче;Дейкстры с метками;");
//            bw.write(sb.toString());
//            bw.newLine();
            for (int i = 0; i <= 10000000  ; i += 100000) {
                System.out.println(i / 100000);
                sb = new StringBuilder();
                sb.append(i + ";");
                int s = new Random().nextInt(10001);
                Graph graph = graphGenerator.generateGraph(10001, i, 1, 1000000);
                long timeHeap = 0;
                long timeMark = 0;
                for (int j = 0; j < 5; j++) {
//                    timeHeap += DijkstraBinaryHeap.dijkstra(graph, s);
//                    timeMark += DijkstraWithMarks.dijkstraWithMarks(graph, s);
                }
                timeHeap /= 5;
                timeMark /= 5;
//                sb.append(timeHeap + ";" + timeMark);
//                bw.write(sb.toString());
//                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
