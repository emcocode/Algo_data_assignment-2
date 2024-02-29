import java.util.Iterator;

public class Problem2 {
    public static void main(String[] args) {
        RandomQueue rq = new RandomQueue();
        rq.enqueue(0);
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(4);
        rq.enqueue(5);
        rq.enqueue(6);
        
        rq.dequeue();
        rq.dequeue();

        rq.enqueue(8);

        // Iterating over the list after dequeueing some elements.
        Iterator<Integer> it = rq.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
