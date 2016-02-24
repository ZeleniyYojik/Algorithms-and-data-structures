import Files.FileWorker;
import Hash.HashTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//lab 1 v7
public class Main {
    public static void main(String[] args) {
        FileWorker fileWorker = new FileWorker("/home/panikun/Документы/Algorithms/resources/data");
       //Генерим файлики
//        try {
//            fileWorker.generate();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ArrayList<ArrayList<String>> lines = null;
        ArrayList<HashTable> tables = new ArrayList<>(fileWorker.getFilesCount());

        //Читам страшный лист листов строк
        try {
            lines = fileWorker.readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Создаем таблицы для каждого файла и заполняем, заодно считаем коллизии и выводим
        for (int i = 0; i < fileWorker.getFilesCount(); i++) {
            HashTable hashTable = new HashTable();
            ArrayList<String> currLines = lines.get(i);
            for (String line : currLines) {
                hashTable.add(line);
            }
            System.out.println("Файл номер: " + i);
            System.out.println("Количество элементов: " + (i * fileWorker.getStep() + fileWorker.getStep()));
            System.out.println("Коллизий: " + hashTable.getCollisions());
            System.out.println();
            tables.add(hashTable);
        }

        System.out.println("=============================================================");

        //Проводим поиска каждого элемента таблицы в каждой таблице, считаем количество сравнений и выводим
        for (int i = 0; i < fileWorker.getFilesCount(); i++) {
            HashTable hashTable = tables.get(i);
            ArrayList<String> currLines = lines.get(i);
            for (String line : currLines) {
                hashTable.search(line);
            }
            System.out.println("Файл номер: " + i);
            System.out.println("Количество элементов: " + (i * fileWorker.getStep() + fileWorker.getStep()));
            System.out.println("Сравнений: " + hashTable.comp);
            System.out.println("Запросов на поиск: " + hashTable.searchCounts);
            System.out.println("Среднее количество сравнений на запрос: " + hashTable.getMean());
            System.out.println();
        }
    }
}
