import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BSTIteratorPreorder implements Iterator<Integer> {
    
    private Stack<BSTNode> stack;

    public BSTIteratorPreorder(BSTNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Cannot create an iterator with a null root.");
        }
        stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
    }

    public boolean hasNext() {
       return !stack.isEmpty();
    }

    /*
     * We use a stack for iterating in the proper order.
     */
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        BSTNode node = stack.pop();
        if (node.getRight() != null) {
            stack.push(node.getRight());
        }
        if (node.getLeft() != null) {
            stack.push(node.getLeft());
        }
        return node.getKey();
    }
}
