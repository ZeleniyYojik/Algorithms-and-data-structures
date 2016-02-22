public class HashCell {
    private int _key;
    private String _value;
    private BinaryTree _binaryTree;

    public void set_key(int _key) {
        this._key = _key;
    }

    public void set_value(String _value) {
        this._value = _value;
    }

    public void set_binaryTree(BinaryTree _binaryTree) {
        this._binaryTree = _binaryTree;
    }

    public int get_key() {
        return _key;
    }

    public String get_value() {
        return _value;
    }

    public BinaryTree get_binaryTree() {
        return _binaryTree;
    }

    public HashCell(int _key, String _value) {
        this._key = _key;
        this._value = _value;
        _binaryTree=new BinaryTree(new TreeNode(_value));
    }
}
