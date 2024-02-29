public class Problem3 {

    public static void main(String[] args) {
        String path = "./DummyDir"; // Use relative path. DummyDir is a folder which contains a bunch of other folders and files
        String[] rootName = path.split("/");
        PathTree t = new PathTree();
        LCRSNode root = new LCRSNode(rootName[rootName.length-1]);
        root.setPath(path);
        t.treeBuilder(path, root); // Build the tree from the path provided
        
        t.findMenu(root); // Search for node and add a child

        System.out.println("Printing content of " + path);
        t.walk(root); // Comment in/out this if you want to walk (and print) the contents of the root
    }    
}
