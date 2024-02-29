public class Problem5 {
    
    public static void main(String[] args) {;

        IsoNode tree1 = new IsoNode("A");
        IsoNode tree2 = new IsoNode("A");

        // Adding the same nodes as in the slides
        tree1.setLeft(new IsoNode("B"));
        tree1.getLeft().setLeft(new IsoNode("D"));
        tree1.getLeft().setRight(new IsoNode("E"));
        tree1.getLeft().getRight().setLeft(new IsoNode("F"));
        tree1.setRight(new IsoNode("C"));
        tree1.getRight().setLeft(new IsoNode("G"));
        tree1.getRight().getLeft().setLeft(new IsoNode("H"));

        tree2.setLeft(new IsoNode("C"));
        tree2.getLeft().setLeft(new IsoNode("G"));
        tree2.getLeft().getLeft().setRight(new IsoNode("H"));
        tree2.setRight(new IsoNode("B"));
        tree2.getRight().setLeft(new IsoNode("E"));
        tree2.getRight().getLeft().setLeft(new IsoNode("F"));
        tree2.getRight().setRight(new IsoNode("D"));

        // Check wheather the trees are isomorphic
        Problem5 t = new Problem5();
        System.out.println("Are the trees isomorphic? " + t.isIsomorphic(tree1, tree2));
    }

    /*
     * The method for checking whather the two provided root nodes are isomorphic or not.
     * Recursively checks children nodes if as long as the right conditions are fulfilled.
     */
    public boolean isIsomorphic(IsoNode node1, IsoNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else if (!node1.getVal().equals(node2.getVal())) {
            return false;
        }

        // If children nodes of current node are the same in both trees, return true.
        // If the children nodes can be mirror swapped to end up in the right slot, return true.
        if (isIsomorphic(node1.getLeft(), node2.getLeft()) && isIsomorphic(node1.getRight(), node2.getRight())) {
            return true;
        } else if (isIsomorphic(node1.getLeft(), node2.getRight()) && isIsomorphic(node1.getRight(), node2.getLeft())) {
            return true; 
        } else {
            return false;
        }
    }
}
