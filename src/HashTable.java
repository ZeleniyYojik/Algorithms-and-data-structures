public class HashTable{
    public HashCell[] cells = new HashCell[10000];

    public int getHashCode(String indentificator) {
        return (int) indentificator.charAt(0) + (int) indentificator.charAt(indentificator.length() - 1);
    }
}
