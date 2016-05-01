import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Variant 4
public class Main {
    public static void main(String args[]) throws IOException {
        try (
                FileReader fileReader = new FileReader("PATH.IN");
                FileWriter fileWriter = new FileWriter("PATH.OUT");
                BufferedWriter writer = new BufferedWriter(fileWriter);
                BufferedReader reader = new BufferedReader(fileReader)
        ) {
            int n = Integer.parseInt(reader.readLine());
            Graph graph = new Graph(n);
            for (int i = 0; i < n; i++) {
                graph.vertices[i] = new Vertex(i + 1);
            }
            int m = Integer.parseInt(reader.readLine());
            for (int i = 0; i < m; i++) {
                String tmp[] = reader.readLine().split(" ");
                int from = Integer.parseInt(tmp[0]);
                int to = Integer.parseInt(tmp[1]);
                Vertex v_from = graph.vertices[from - 1];
                Vertex v_to = graph.vertices[to - 1];
                Edge edge = new Edge(v_from, v_to);
                v_from.edges.add(edge);
            }
            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());
            int c = Integer.parseInt(reader.readLine());
            Vertex v_b = graph.vertices[b - 1];
            Vertex v_c = graph.vertices[c - 1];
            Dijkstra.dijkstra(graph, a - 1);
            if (v_c.prev == null) {
                writer.write("-1");
                writer.newLine();
                System.out.println(-1);
                return;
            }
            List<Vertex> pathToC = new ArrayList<>();
            int cnt = 0;
            Vertex v = v_c;
            do {
                pathToC.add(v);
                cnt++;
                v.setEdgeVisited();
                v = v.prev;
            } while (v != null);
            Dijkstra.dijkstra(graph, c - 1);
            if (v_b.prev == null) {
                writer.write("-1");
                writer.newLine();
                System.out.println(-1);
                return;
            }
            List<Vertex> pathToB = new ArrayList<>();
            v = v_b;
            do {
                pathToB.add(v);
                cnt++;
                v = v.prev;
            } while (v.prev != null);
            writer.write("" + cnt);
            System.out.println(cnt);
            writer.newLine();
            for (int i = pathToC.size() - 1; i >= 0; i--) {
                writer.write("" + pathToC.get(i).numb);
                writer.newLine();
                System.out.println(pathToC.get(i).numb);
            }
            for (int i = pathToB.size() - 1; i >= 0; i--) {
                writer.write("" + pathToB.get(i).numb);
                writer.newLine();
                System.out.println(pathToB.get(i).numb);
            }
        }
    }
}