import Hash.HashCell;
import Hash.HashTable;

import java.io.IOException;
import java.util.List;

//lab 1 v7
public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        FileWorker fileWorker = new FileWorker("/home/panikun/Документы/Algorithms/resources/data");
        List<String> lines = null;
        try {
            lines = fileWorker.readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : lines) {
            hashTable.add(line);
        }
        hashTable.remove("YnvdXdhpVRDBjjiStwjTPmSDvpHvyCMA");
        for (String line : lines) {
            hashTable.search(line);
        }
        System.out.println("Коллизий: " + hashTable.getCollisions());
        System.out.println("Сравнений: " + HashTable.comp);
        System.out.println("Запросов на поиск: " + HashTable.searchCounts);
        System.out.println("Среднее количество сравнений на запрос: " + hashTable.getMean());
    }
}
