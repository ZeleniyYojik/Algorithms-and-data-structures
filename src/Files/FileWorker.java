package Files;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileWorker {
    private String path;
    private int fileCounts = 10;
    private int step = 100;

    public List readFromFile() throws IOException {
        String line;
        List<String> result = new ArrayList<>();
        try (
                InputStream fis = new FileInputStream(path);
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr)
        ) {
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        }
        return result;
    }

    public void generate() throws IOException {
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < fileCounts; i++) {
            try (
                    OutputStream ous = new FileOutputStream(path + Integer.toString(i));
                    OutputStreamWriter ouw = new OutputStreamWriter(ous, Charset.forName("UTF-8"));
                    BufferedWriter bw = new BufferedWriter(ouw)
            ) {
                for (int j = 0; j < step + i * step; j++) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int k = 0; k < 32; k++) {
                        stringBuffer.append((char)(random.nextInt(78)+48));
                    }
                    bw.write(stringBuffer.toString());
                }
            }
        }
    }

    public FileWorker(String path) {
        this.path = path;
    }
}
