import java.util.Iterator;

public class AVLTree {
    
    private AVLNode root;

    public AVLTree() {}

    public void printPreorder() {
        _preOrder(root);
    }
    
    /*
     * Simple prinout of the AVL tree - preorder.
     */
    private void _preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.getKey() + " ");
            _preOrder(node.getLeft());
            _preOrder(node.getRight());
        }
    }

    public void add(int key) {
        root = _add(root, key);
    }

    /*
     * Private method for adding a new element.
     * Add element, THEN balance.
     */
    private AVLNode _add(AVLNode node, int key) {
        if (node == null) {
            return new AVLNode(key);
        }

        if (node.getKey() > key) {
            node.setLeft(_add(node.getLeft(), key));
        } else if (node.getKey() < key) {
            node.setRight(_add(node.getRight(), key));
        }
        return _balance(node);
    }

    /*
     * Balance method for the tree.
     */
    private AVLNode _balance(AVLNode node) {
        if (node == null) {
            return node;
        }

        if (_height(node.getLeft()) - _height(node.getRight()) > 1) {
            if (_height(node.getLeft().getLeft()) >= _height(node.getLeft().getRight())) {
                node = _rotateLeft(node);
            } else {
                node = _doubleRotateLeft(node);
            }
        } else if (_height(node.getRight()) - _height(node.getLeft()) > 1) {
            if (_height(node.getRight().getRight()) >= (_height(node.getRight().getLeft()))) {
                node = _rotateRight(node);
            } else {
                node = _doubleRotateRight(node);
            }
        }
        node.setHeight(Math.max(_height(node.getLeft()), _height(node.getRight())));
        return node;
    } 

    /*
     * Get total height of the tree.
     */
    public int getHeight() {
        return _height(root);
    }
    /*
     * Private method for height.
     */
    private int _height(AVLNode node) {
        if (node == null) {
            return -1;
        }
        return Math.max(_height(node.getLeft()), _height(node.getRight())) + 1;
    }

    /*
     * Single rotate left.
     */
    private AVLNode _rotateLeft(AVLNode r2) {
        AVLNode r1 = r2.getLeft();
        r2.setLeft(r1.getRight());
        r1.setRight(r2);
        r2.setHeight(Math.max(_height(r2.getLeft()), _height(r2.getRight())) + 1);
        r1.setHeight(Math.max(_height(r1.getLeft()), _height(r1.getRight())) + 1);
        return r1;
    }

    /*
     * Double rotate left.
     */
    private AVLNode _doubleRotateLeft(AVLNode node) {
        node.setLeft(_rotateRight(node.getLeft()));
        return _rotateLeft(node);
    }

    /*
     * Single rotate right.
     */
    private AVLNode _rotateRight(AVLNode r2) {
        AVLNode r1 = r2.getRight();
        r2.setRight(r1.getLeft());
        r1.setLeft(r2);
        r2.setHeight(Math.max(_height(r2.getLeft()), _height(r2.getRight())) + 1);
        r1.setHeight(Math.max(_height(r1.getLeft()), _height(r1.getRight())) + 1);
        return r1;
    }

    /*
     * Double rotate right.
     */
    private AVLNode _doubleRotateRight(AVLNode node) {
        node.setRight(_rotateLeft(node.getRight()));
        return _rotateRight(node);
    }

    /*
     * Iterator (preorder)
     */
    public Iterator iterator() {
        return new AVLIterator(root);
    }

    public int getSize() {
        Iterator iter = new AVLIterator(root);
        int size = 0;
        while (iter.hasNext()) {
            iter.next();
            size += 1;
        }
        return size;
    }

    /*
     * Public remove method.
     */
    public void remove(int key) {
        root = _remove(root, key);
    }

    /*
     * Remove a node.
     */
    private AVLNode _remove(AVLNode node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.getKey()) {
            node.setLeft(_remove(node.getLeft(), key));
        } else if (key > node.getKey()) {
            node.setRight(_remove(node.getRight(), key));
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            } else if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                AVLNode successor = findMin(node.getRight());
                node.setKey(successor.getKey());
                node.setRight(_remove(node.getRight(), successor.getKey()));
            }
        }
        return _balance(node);
    }

    /*
     * Traversing down left to find min node.
     */
    private AVLNode findMin(AVLNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    /*
     * Find a node.
     */
    private AVLNode _find(AVLNode node, int key) {
        if (node == null)
            return null;
        else if (node.getKey() == key)
            return node;
        else if (key < node.getKey())
            return _find(node.getLeft(), key);
        else
            return _find(node.getRight(), key);
    }

    public AVLNode find(int key) {
        return _find(root, key);
    }
}
