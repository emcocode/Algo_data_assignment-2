public class DQNode<T> {

    private T val;
    private DQNode<T> nxt;

    public DQNode(T val) {
        this.val = val;
    }

    public void setNext(DQNode<T> newNode) {
        this.nxt = newNode;
    }

    public DQNode<T> getNext() {
        return this.nxt;
    }  

    public T getVal() {
        return this.val;
    }
}
