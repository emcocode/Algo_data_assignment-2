import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RQIterator implements Iterator<Integer> {

    private Integer[] queue;
    private int loc;

    /*
     * Iterator that keeps track of updates in the random queue. For example, if an element is added or removed,
     * it is then shown the next time the same iterator is being ran.
     */
    public RQIterator(Integer[] q) {
        queue = q.clone();
        loc = queue.length - 1;
        Random rn = new Random();
        for (int i = queue.length - 1; i > 0; i--) {
            int j = rn.nextInt(i + 1);
            Integer tmp = queue[i];
            queue[i] = queue[j];
            queue[j] = tmp;
        }
    }

    /*
     * HasNext method.
     */
    public boolean hasNext() {
        if (queue.length == 0) {
            return false;
        }
        while (loc >= 0 && queue[loc] == null) {
            loc--;
        }
        return loc >= 0;
    }

    /*
     * Next method.
     */
    public Integer next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        return queue[loc--];
    }
}
