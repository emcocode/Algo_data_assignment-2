public class IsoNode {
    
    private String val;
    private IsoNode left;
    private IsoNode right;

    public IsoNode(String newVal) {
        val = newVal;
        left = null;
        right = null;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String newVal) {
        val = newVal;
    }

    public IsoNode getLeft() {
        return left;
    }

    public void setLeft(IsoNode newLeft) {
        left = newLeft;
    }

    public IsoNode getRight() {
        return right;
    }

    public void setRight(IsoNode newRight) {
        right = newRight;
    }
}
