public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        if (hashTable.cells[hashTable.getHashCode("вася")] == null) {
            hashTable.cells[hashTable.getHashCode("вася")] = new HashCell(hashTable.getHashCode("вася"), "вася");
        }
        System.out.println(hashTable.cells[hashTable.getHashCode("вася")].get_value());
        System.out.println(hashTable.getHashCode("вася"));
    }
}
