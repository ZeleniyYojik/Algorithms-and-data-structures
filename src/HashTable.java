public class HashTable {
    public HashCell[] cells = new HashCell[2300];
    private int collisions = 0;

    public int getCollisions() {
        return collisions;
    }

    public void add(String value) {
        int hashCode = getHashCode(value);
        HashCell cell = cells[hashCode];
        if (cell == null) {
            cells[hashCode] = new HashCell(hashCode, value);
        } else if (cell.get_value() == value) {
            return;
        } else {
            if (cell.get_binaryTree().search(value)) { //для подсчета количества коллизий т.к. можем посчитать за коллизию уже записаное в дерево значение
                collisions++;                          //, иначе можно просто делать add.
                cell.get_binaryTree().add(value);
            }
        }
    }

    public boolean search(String value) {
        HashCell cell = cells[getHashCode(value)];
        if (cell == null) {
            return false;
        }
//        if (cell.get_value() == value) {
//            return true;
//        }
        return cell.get_binaryTree().search(value);
    }

    public int getHashCode(String identifier) {
        return (int) identifier.charAt(0) + (int) identifier.charAt(identifier.length() - 1);
    }
}
