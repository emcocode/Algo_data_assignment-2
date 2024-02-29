import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BSTIteratorInorder implements Iterator<Integer> {
    
    private Stack<BSTNode> stack;

    public BSTIteratorInorder(BSTNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Cannot create an iterator with a null root.");
        }
        stack = new Stack<>();
        pushLeft(root);
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
        pushLeft(node.getRight());
        return node.getKey();
    }

    public void pushLeft(BSTNode node) {
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }
    }
}
