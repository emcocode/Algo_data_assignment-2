import java.util.Iterator;
import java.util.NoSuchElementException;

public class DQIterator<T> implements Iterator<T> {

    private DQNode<T> node;
    
    public DQIterator(DQNode<T> headNode) {
        node = headNode;
    }

    public boolean hasNext() {
        return node != null;
    }

    /*
     * Next method for iterator.
     */
    public T next() {
        if (node == null) {
            throw new NoSuchElementException("No more elements in deque.");
        }
        T tmp = node.getVal();
        node = node.getNext();
        return tmp;
    }
    
}
