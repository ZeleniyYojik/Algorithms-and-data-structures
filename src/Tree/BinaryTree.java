package Tree;

import Hash.HashTable;

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
            HashTable.comp++;

            if (curr.getValue().compareTo(value) > 0) {
                HashTable.comp++;
                if (curr.getLeft() == null) {
//                    HashTable.comp++;
                    return false;
                } else {
//                    HashTable.comp++;
                    curr = curr.getLeft();
                }
            } else {
                HashTable.comp++;
            }

            if (curr.getValue().compareTo(value) < 0) {
                HashTable.comp++;
                if (curr.getRight() == null) {
//                    HashTable.comp++;
                    return false;
                } else {
//                    HashTable.comp++;
                    curr = curr.getRight();
                }
            } else {
                HashTable.comp++;
            }
        }
    }

    public void remove(String value) {
        TreeNode toRemove = searchNode(value);
        if (toRemove == null) {
            return;
        }
        if (toRemove == root) {
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
                return;
            } else if (root.getLeft() == null || root.getRight() == null) {
                if (root.getLeft() == null) {
                    root = root.getRight();
                }
                if (root.getRight() == null) {
                    root = root.getLeft();
                }
                return;
            } else {
                TreeNode next = findMin(root.getRight());
                root.setValue(next.getValue());//не меняем сами узлы, а меняем их значения - проще и быстрее
                if (next.getParent().getLeft() == next) {
                    next.getParent().setLeft(next.getRight());
                    if (next.getRight() != null) {
                        next.getRight().setParent(next.getParent());
                    }
                } else {
                    next.getParent().setRight(next.getRight());
                    if (next.getRight() != null) {
                        next.getRight().setParent(next.getParent());
                    }
                }
            }
            return;
        }

        TreeNode parent = toRemove.getParent();
        if (toRemove.getLeft() == null && toRemove.getRight() == null)   {
            if (parent.getLeft() == toRemove) {
                parent.setLeft(null);
                return;
            }
            if (parent.getRight() == toRemove) {
                parent.setRight(null);
                return;
            }
        } else if (toRemove.getRight() == null || toRemove.getLeft() == null) {
            if (toRemove.getLeft() == null) {
                if (parent.getLeft() == toRemove) {
                    parent.setLeft(toRemove.getRight());
                } else {
                    parent.setRight(toRemove.getRight());
                }
                toRemove.getRight().setParent(parent);
            } else {
                if (parent.getLeft() == toRemove) {
                    parent.setLeft(toRemove.getLeft());
                } else {
                    parent.setRight(toRemove.getLeft());
                }
                toRemove.getLeft().setParent(parent);
            }
        } else {
            TreeNode next = findMin(toRemove.getRight());
            toRemove.setValue(next.getValue());//не меняем сами узлы, а меняем их значения - проще и быстрее
            if (next.getParent().getLeft() == next) {
                next.getParent().setLeft(next.getRight());
                if (next.getRight() != null) {
                    next.getRight().setParent(next.getParent());
                }
            } else {
                next.getParent().setRight(next.getRight());
                if (next.getRight() != null) {
                    next.getRight().setParent(next.getParent());
                }
            }
        }

    }

    public TreeNode searchNode(String value) {
        TreeNode curr = root;
        while (true) {
            if (curr.getValue().compareTo(value) == 0) {
                return curr;
            }

            if (curr.getValue().compareTo(value) > 0) {
                if (curr.getLeft() == null) {
                    return null;
                }
                curr = curr.getLeft();
            }

            if (curr.getValue().compareTo(value) < 0) {
                if (curr.getRight() == null) {
                    return null;
                } else {
                    curr = curr.getRight();
                }
            }
        }
    }

    public TreeNode findMin(TreeNode node) {
        TreeNode curr = node;
        while (curr.getLeft() != null) {
            curr = curr.getLeft();
        }
        return curr;
    }

    public TreeNode findMax(TreeNode node) {
        TreeNode curr = node;
        while (curr.getRight() != null) {
            curr = curr.getRight();
        }
        return curr;
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }
}
