import Dijkstra.DijkstraBinaryHeap;
import GraphPack.Graph;
import GraphPack.GraphGenerator;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try (
                OutputStream ous = new FileOutputStream("output.csv");
                OutputStreamWriter ouw = new OutputStreamWriter(ous, Charset.forName("UTF-8"));
                BufferedWriter bw = new BufferedWriter(ouw)
        ) {
            GraphGenerator graphGenerator = new GraphGenerator();
            for (int i = 0; i < 10000000; i += 100000) {
                System.out.println(i / 100000);
                StringBuilder sb = new StringBuilder();
                sb.append(i + ";");
                int s = new Random().nextInt(10001);
                Graph graph = graphGenerator.generateGraph(10001, i, 1, 1000000);
                long time = 0;
                for (int j = 0; j < 100; j++) {
                    time += DijkstraBinaryHeap.dijkstra(graph, s);
                }
                time /= 100;
                sb.append(time + ";");
                bw.write(sb.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
