import Boruvka.Boruvka;
import GraphPack.Edge;
import GraphPack.Graph;
import GraphPack.GraphGenerator;
import GraphPack.Vertex;
import Prima.PrimaBinaryHeap;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        GraphGenerator graphGenerator = new GraphGenerator();
//        System.out.println("Исходный");
//        Printer.print(graph);
//        List<Edge> prima = new ArrayList<>();
//        System.out.println("Прима");
//        PrimaBinaryHeap.prima(graph, 2, prima);
//        Printer.print(prima);
//        System.out.println("Борувка");
//        Graph bor = new Graph();
//        bor.setVertexes(new ArrayList<>());
//        for (int i = 0; i < graph.getVertexes().size(); i++) {
//            graph.getVertexes().get(i).index = i;
//        }
//        List<Edge> resBor = new ArrayList<>();
//        Boruvka.boruvka(graph, bor, resBor);
//        Printer.print(resBor);
//        System.out.println();

        try (
                OutputStream ous = new FileOutputStream("outputTest.csv");
                OutputStreamWriter ouw = new OutputStreamWriter(ous, Charset.forName("UTF-8"));
                BufferedWriter bw = new BufferedWriter(ouw)
        ) {
            StringBuilder sb = new StringBuilder();
            sb.append("Количество ребер;Алгоритм Прима;Алгоритм Борувки;");
            bw.write(sb.toString());
            bw.newLine();
            for (int i = 100000; i <= 10000000; i += 100000) {
                System.out.print(i / 100000);
                sb = new StringBuilder();
                sb.append(i + ";");
                Graph graph = graphGenerator.generateGraph(10001, i, 1, 1000000);
                long timePrima = 0;
                long timeBoruvka = 0;
                List<Edge> resPrima = new ArrayList<>();
                List<Edge> resBoruvka = new ArrayList<>();
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < graph.getVertexes().size(); k++) {
                        graph.getVertexes().get(k).index = k;
                    }
                    timePrima += PrimaBinaryHeap.prima(graph, 0, resPrima);
                    for (int k = 0; k < graph.getVertexes().size(); k++) {
                        graph.getVertexes().get(k).index = k;
                    }
                    timeBoruvka += Boruvka.boruvka(graph, new Graph(), resBoruvka);
                }
                int sumPrima = 0;
                int sumBoruvka = 0;
                for (int j = 0; j < resBoruvka.size(); j++) {
                    sumPrima += resPrima.get(j).getWeight();
                    sumBoruvka += resBoruvka.get(j).getWeight();
                }
                timePrima /= 5;
                timeBoruvka /= 5;
                System.out.println(" Prima: " + timePrima + "ms" + " W: " + sumPrima + "  Boruvka: " + timeBoruvka + "ms" + " W: " + sumBoruvka);
                sb.append(timePrima + ";" + timeBoruvka);
                bw.write(sb.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
