import java.util.Iterator;
import java.util.NoSuchElementException;

public class BST implements Iterable<Integer> {

    private BSTNode root;

    public BST() {}

    public void add(int key) {
        root = _add(root, key);
    }

    /*
     * Private _add method which does the actual adding.
     */
    private BSTNode _add(BSTNode node, int key) {
        if (node == null) {
            return new BSTNode(key);
        }

        if (node.getKey() > key) {
            node.setLeft(_add(node.getLeft(), key));
        } else if (node.getKey() < key) {
            node.setRight(_add(node.getRight(), key));
        }
        return node;
    }

    public int size() {
        return _size(root);
    }

    /*
     * Private _size method which calculates the size.
     */
    private int _size(BSTNode node) {
        if (node == null) {
            return 0;
        }
        else {
            int sz = _size(node.getLeft());
            sz += 1;
            sz += _size(node.getRight());
            return sz;
        }
    }

    public int height() {
        return _height(root);
    }

    /*
     * Private _height method for getting the height.
     */
    private int _height(BSTNode node) {
        if (node == null) {
            return -1;
        }
        else {
            return 1 + Math.max(_height(node.getLeft()), _height(node.getRight()));
        }
    }
    
    public boolean contains(int key) {
        return _contains(root, key);
    }

    /*
     * Checking wheather the tree contains *key* or not.
     */
    private boolean _contains(BSTNode node, int key) {
        if (node == null) {
            return false;
        }
        if (node.getKey() > key) {
            return _contains(node.getLeft(), key);
        } else if (node.getKey() < key) {
            return _contains(node.getRight(), key);
        } else {
            return true;
        }
    }

    public void remove(int key) {
        _remove(root, key);
    }

    /*
     * Removes a certain element from the tree.
     */
    private BSTNode _remove(BSTNode node, int key) {
        if (node == null) {
            return null;
        }
        if (node.getKey() > key) {
            node.setLeft(_remove(node.getLeft(), key));
        } else if (node.getKey() < key) {
            node.setRight(_remove(node.getRight(), key));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }
            node.setKey(_min(node.getRight()));
            node.setRight(_remove(node.getRight(), node.getKey()));
        }
        return node;
    }
    
    /*
     * Gets the min value.
     */
    private int _min(BSTNode node) {
        if (node.getLeft() == null) {
            return node.getKey();
        } else {
            return _min(node.getLeft());
        }
    }

    /*
     * Remove the kth largest element. Iterate through the tree in order until reaching the kth largest element.
     * Then just call remove.
     */
    public Integer removeKthLargest(int k) {
        if ((k < 1) || k > size()) {
            throw new NoSuchElementException("There is no " + k + ":th largest value.");
        }
        Iterator<Integer> numbers = new BSTIteratorInorder(root);
        int count = 0;
        Integer kthLargest = null;
        while (numbers.hasNext() && count < (size() + 1) - k) {
            kthLargest = (Integer) numbers.next();
            count += 1;
        }
        remove(kthLargest);
        return kthLargest;
    }


    /*
     * Find a node.
     */
    private BSTNode _find(BSTNode node, int key) {
        if (node == null)
            return null;
        else if (node.getKey() == key)
            return node;
        else if (key < node.getKey())
            return _find(node.getLeft(), key);
        else
            return _find(node.getRight(), key);
    }

    public BSTNode find(int key) {
        return _find(root, key);
    }

    /*
     * Specifically call the in-order iterator.
     */
    public Iterator<Integer> iteratorInorder() {
        return new BSTIteratorInorder(root);
    }

    /*
     * Specifically call the pre-order iterator.
     */
    public Iterator<Integer> iteratorPreorder() {
        return new BSTIteratorPreorder(root);
    }

    /*
     * Specifically call the post-order iterator.
     */
    public Iterator<Integer> iteratorPostorder() {
        return new BSTIteratorPostorder(root);
    }

    /*
     * The unspecified iterator() method, usable for all types of iteration by commenting out/in which to use.
     * By default, it is in-order.
     */
    public Iterator<Integer> iterator() {
        return new BSTIteratorInorder(root);
        // return new BSTIteratorPreorder(root);
        // return new BSTIteratorPostorder(root);
    }
}
