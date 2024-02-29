public class LCRSNode {
    
    private String key;
    private LCRSNode left;
    private LCRSNode right;
    private String path;

    public LCRSNode(String newKey) {
        key = newKey;
    }

    public String getKey() {
        return key;
    }

    public LCRSNode getLeft() {
        return left;
    }

    public LCRSNode getRight() {
        return right;
    }

    public void setLeft(LCRSNode newLeft) {
        left = newLeft;
    }

    public void setRight(LCRSNode newRight) {
        right = newRight;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String newPath) {
        path = newPath;
    }
}
