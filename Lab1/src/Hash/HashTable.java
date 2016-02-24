package Hash;

public class HashTable {
    public HashCell[] cells = new HashCell[100];
    private int collisions = 0; //
    public int searchCounts = 0;//Для сбора статистики
    public int comp = 0;        //

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
        }
        if (cell == null) {
            cells[hashCode] = new HashCell(value, this);
        }  else {
            if (!cell.get_binaryTree().search(value)) { //для подсчета количества коллизий т.к. можем посчитать за коллизию уже записаное в дерево значение,
                collisions++;                           //иначе можно просто делать add.
                cell.get_binaryTree().add(value);
            }
        }
    }

    public boolean search(String value) {
        this.searchCounts++;
        HashCell cell = cells[getHashCode(value)];
        if (cell == null) {
         //   this.comp++;
            return false;
        }
       // this.comp++;
        return cell.get_binaryTree().search(value);
    }

    public void remove(String value) {
        int hash = getHashCode(value);
        HashCell cell = this.cells[hash];
        if (cell == null) {
            return;
        }
        cell.get_binaryTree().remove(value);
        if (cell.get_binaryTree().getRoot() == null) {
            this.cells[hash] = null;
            return;
        }
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

    //Получение среднего количества сравнений
    public int getMean() {
        return comp / searchCounts;
    }

    public void setCollisions(int collisions) {
        this.collisions = collisions;
    }

    public void setSearchCounts(int searchCounts) {
        this.searchCounts = searchCounts;
    }

    public void setComp(int comp) {
        this.comp = comp;
    }
}
