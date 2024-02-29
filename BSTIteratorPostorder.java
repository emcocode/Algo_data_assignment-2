import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BSTIteratorPostorder implements Iterator<Integer> {
    
    private Stack<BSTNode> stack1;
    private Stack<BSTNode> stack2;

    /*
     * We use TWO stacks for iterating in the proper order.
     */
    public BSTIteratorPostorder(BSTNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Cannot create an iterator with a null root.");
        }
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        if (root != null) {
            stack1.push(root);
        }
        while (!stack1.isEmpty()) {
            BSTNode node = stack1.pop();
            stack2.push(node);
            if (node.getLeft() != null) {
                stack1.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack1.push(node.getRight());
            }
        }
    }

    public boolean hasNext() {
       return !stack2.isEmpty();
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return stack2.pop().getKey();
    }
}
