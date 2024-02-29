public class BSTNode {
    
    private int key;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(int newKey) {
        key = newKey;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int newKey) {
        key = newKey;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setLeft(BSTNode newLeft) {
        left = newLeft;
    }

    public void setRight(BSTNode newRight) {
        right = newRight;
    }
}
