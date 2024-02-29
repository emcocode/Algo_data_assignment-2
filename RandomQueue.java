import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomQueue implements Iterable<Integer> {

    private Integer[] queue;
    private int qSize;
    private int added; // Since we shouldn´t move the last element, we use this to keep track of the last place in the queue - so we know where to add
    private Random rn;

    public RandomQueue() {
        queue = new Integer[4];
        qSize = 0;
        added = 0;
        rn = new Random();
    }

    /*
     * Enqueue a new number to the queue.
     */
    public void enqueue(int nr) {
        if (added == queue.length) { // Doubling array size if full
            Integer[] newQueue = new Integer[queue.length * 2];
            int j = 0;
            for (int i = 0; i < queue.length; i++) {
                if (queue[i] != null) {
                    newQueue[j] = queue[i];
                    j += 1;
                }
            }
            queue = newQueue;
            added = qSize;
        }
        queue[added] = nr;
        qSize += 1;
        added += 1;
    }

    /*
     * Remove a random element in the queue.
     */
    public Integer dequeue() {
        if (!isEmpty()) {
            Integer rmSlot = rn.nextInt(queue.length);
            while (queue[rmSlot] == null) {
                rmSlot = rn.nextInt(queue.length);
            }
            Integer returnValue = queue[rmSlot];
            qSize -= 1;
            queue[rmSlot] = null;
            if (qSize <= (queue.length / 4)) { // Shrink when too few elements in relation to queue
                Integer[] newQueue = new Integer[queue.length / 2];
                int j = 0;
                for (int i = 0; i < queue.length; i++) {
                    if (queue[i] != null) {
                        newQueue[j] = queue[i];
                        j += 1;
                    }
                }
                added = qSize;
                queue = newQueue;
            }
            return returnValue;
        } else {
            throw new NoSuchElementException("The queue is already empty.");
        }
    }

    public int size() {
        return qSize;
    }

    public boolean isEmpty() {
        return qSize == 0;
    }

    /*
     * Iterator for the queue.
     */
    public Iterator<Integer> iterator() {
        return new RQIterator(queue);
    }
}
