import java.io.*;

//Variant 4
public class Main {
    public static void main(String args[]) throws IOException {
        try (
                FileReader fileReader = new FileReader("PATH.IN");
                FileWriter fileWriter = new FileWriter("PATH.OUT");
                BufferedWriter writer = new BufferedWriter(fileWriter);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            int n = Integer.parseInt(reader.readLine());
            Graph graph = new Graph(n);
            for (int i = 0; i < n; i++) {
                graph.vertices[n] = new Vertex(n + 1);
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
        }
    }
}