package Hash;

import Tree.BinaryTree;
import Tree.TreeNode;


public class HashCell {
    private BinaryTree _binaryTree;
    private HashTable table;


    public BinaryTree get_binaryTree() {
        return _binaryTree;
    }

    public HashCell(String _value, HashTable table) {
        this.table = table;
        _binaryTree = new BinaryTree(new TreeNode(_value, null), table);
    }
}
