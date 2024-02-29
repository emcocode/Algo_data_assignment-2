import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class AVLIterator implements Iterator {
    
    private Stack<AVLNode> stack;

    public AVLIterator(AVLNode root) {
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
        AVLNode node = stack.pop();
        if (node.getRight() != null) {
            stack.push(node.getRight());
        }
        if (node.getLeft() != null) {
            stack.push(node.getLeft());
        }
        return node.getKey();
    }
}
