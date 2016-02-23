import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class FileWorker {
    private String path;

    public List readFromFile() throws IOException {
        String line;
        List<String> result = new ArrayList<>();
        try (
                InputStream fis = new FileInputStream(path);
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr);
        ) {
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        }
        return result;
    }

    public FileWorker(String path) {
        this.path = path;
    }
}
