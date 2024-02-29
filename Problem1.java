import java.util.Iterator;

public class Problem1 {

    /*
     * The main class runs a few tests on the Deque.
     */
    public static void main(String[] args) {
        Deque<Integer> dq = new Deque<>();
        dq.addLast(1);
        dq.addLast(2);
        dq.addLast(3);
        for (int i = 4; i < 25; i++) {
            dq.addLast(i);
        }
        dq.removeFirst();
        dq.removeLast();
        dq.removeLast();
        dq.removeLast();
        Iterator<Integer> iterator = dq.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Size: " + dq.size());
        System.out.println("Is the list empty: " + dq.isEmpty());

    }
}