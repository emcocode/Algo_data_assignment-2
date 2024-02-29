import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<T> implements Iterable<T> {

    private DQNode<T> node;
    private int sz;

    public Deque() {
        this.node = null;
        sz = 0;
    }

    /*
     * Adds an element last in the queue.
     */
    public void addLast(T newVal) {
        if (node == null) {
            this.node = new DQNode<T>(newVal);
        } else {
            DQNode<T> p = this.node;
            while (p.getNext() != null) {
                p = p.getNext();
            }
            p.setNext(new DQNode<T>(newVal));
        }  
        sz += 1;  
    }

    /*
     * Adds an element first in the queue.
     */
    public void addFirst(T newVal) {
        if (node == null) {
            this.node = new DQNode<T>(newVal);
        } else {
            DQNode<T> p = node;
            node = new DQNode<T>(newVal);
            node.setNext(p);
        } 
        sz += 1;
    }

    /*
     * Removes the first element in the queue.
     */
    public void removeFirst() {
        if (node == null) {
            throw new NoSuchElementException("Cannot remove element, since the list is already empty.");
            // System.out.println("Cannot remove element, since the list is already empty.");
        }            
        node = node.getNext();
        sz -= 1;
    }

    /*
     * Removes the last element in the queue.
     */
    public void removeLast()  {
         if (node == null) {
            throw new NoSuchElementException("Cannot remove element, since the list is already empty.");
            // System.out.println("Cannot remove element, since the list is already empty.");
        } else if (node.getNext() == null) {
            node = null;
        } else {
            DQNode<T> p = this.node;
            while (p.getNext().getNext() != null) {
                p = p.getNext();
            }
            p.setNext(null);
        }
        sz -= 1;
    }

    public int size() {
        return sz;  
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterator<T> iterator() {
        return new DQIterator<T>(node);
    }

}
