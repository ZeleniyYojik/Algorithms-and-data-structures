public class BinaryTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void add(String value) {
        TreeNode curr = root;
        while (true) {
            if (curr.getValue().compareTo(value) == 0) {
                return;
            }
            if (curr.getValue().compareTo(value) > 0) {
                if (curr.getLeft() == null) {
                    curr.setLeft(new TreeNode(value, curr));
                    return;
                } else {
                    curr = curr.getLeft();
                }
            }
            if (curr.getValue().compareTo(value) < 0) {
                if (curr.getRight() == null) {
                    curr.setRight(new TreeNode(value, curr));
                    return;
                } else {
                    curr = curr.getRight();
                }
            }
        }
    }

    public boolean search(String value) {
        TreeNode curr = root;
        while (true) {
            if (curr.getValue().compareTo(value) == 0) {
                HashTable.comp++;
                return true;
            }
            if (curr.getValue().compareTo(value) > 0) {
                HashTable.comp++;
                if (curr.getLeft() == null) {
                    HashTable.comp++;
                    return false;
                } else {
                    curr = curr.getLeft();
                }
            }
            if (curr.getValue().compareTo(value) < 0) {
                HashTable.comp++;
                if (curr.getRight() == null) {
                    HashTable.comp++;
                    return false;
                } else {
                    curr = curr.getRight();
                }
            }
        }
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }
}
