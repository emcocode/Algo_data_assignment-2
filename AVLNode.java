public class AVLNode {
    
    private int key;
    private AVLNode left;
    private AVLNode right;
    private int height;

    public AVLNode(int newKey) {
        key = newKey;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int newKey) {
        key = newKey;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int newHeight) {
        height = newHeight;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode newLeft) {
        left = newLeft;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode newRight) {
        right = newRight;
    }
}
