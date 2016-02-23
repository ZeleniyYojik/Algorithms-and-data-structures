package Hash;

public class HashTable {
    public HashCell[] cells = new HashCell[100];
    private int collisions = 0; //Возможно надо сделать выборку по нескольким разным файлам для получения среднего значения
    public static int searchCounts = 0;//Для сбора статистики
    public static int comp = 0;        //

    public int getCollisions() {
        return collisions;
    }

    public void add(String value) {
        int hashCode = getHashCode(value);
        HashCell cell = null;
        try {
            cell = cells[hashCode];
        } catch (IndexOutOfBoundsException e) {
            this.resize(hashCode);
            System.out.println("RESIZE!!");
        }
        if (cell == null) {
            cells[hashCode] = new HashCell(hashCode, value);
        } else if (cell.get_value() == value) {
            return;
        } else {
            if (!cell.get_binaryTree().search(value)) { //для подсчета количества коллизий т.к. можем посчитать за коллизию уже записаное в дерево значение,
                collisions++;                           //иначе можно просто делать add.
                cell.get_binaryTree().add(value);
            }
        }
    }

    public boolean search(String value) {
        HashTable.searchCounts++;
        HashCell cell = cells[getHashCode(value)];
        if (cell == null) {
            HashTable.comp++;
            return false;
        }
        HashTable.comp++;
        return cell.get_binaryTree().search(value);//т.к. поиск в ячейке - поиск по дереву, можно не сравнивать значение самой ячейки, а уйти сразу в дерево
    }

    public int getHashCode(String identifier) {
        return (int) identifier.charAt(0) + (int) identifier.charAt(identifier.length() - 1);
    }

    private void resize(int newSize) {
        HashCell[] newCells = new HashCell[newSize + 1];
        for (int i = 0; i < this.cells.length; i++) {
            newCells[i] = this.cells[i];
        }
        this.cells = newCells;
    }

    public int getMean() {
        return comp / searchCounts;
    }
}
