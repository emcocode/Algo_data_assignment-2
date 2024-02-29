import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PathTree {
    private int depth;
    private Scanner sc;

    public PathTree() {
        depth = 0;
        sc = new Scanner(System.in);
    }

    /*
     * Build the tree from the provided path.
     */
    public void treeBuilder(String path, LCRSNode parent) {
        File[] content = new File(path).listFiles(); // Array is only used temporarily to list the contents of the folder
        if (content != null) {
            for (File node : content) {
                LCRSNode nodeToAdd = new LCRSNode(node.getName());
                nodeToAdd.setPath(parent.getPath() + "/" + node.getName());
                if (node.isDirectory()) {
                    treeBuilder(node.getAbsolutePath(), nodeToAdd);
                }
                addChild(parent, nodeToAdd);
            }
        }
    }

    /*
     * Adding a child node the the provided parent.
     */
    public LCRSNode addChild(LCRSNode parent, LCRSNode nodeToAdd) {
        if (parent.getLeft() == null) {
            parent.setLeft(nodeToAdd);
            return parent.getLeft();
        } else {
            LCRSNode tmp = parent.getLeft();
            while (tmp.getRight() != null) {
            tmp = tmp.getRight();
            }
            tmp.setRight(nodeToAdd);
            return tmp.getRight();
        }
    }

    /*
     * Walk the tree for printing.
     */
    public void walk(LCRSNode node) {
        System.out.println("----".repeat(depth) + node.getKey());
        if (node.getLeft() != null) {
            depth += 1;
            walk(node.getLeft());
            depth -= 1;
        }
        if (node.getRight() != null) {
            walk(node.getRight());
        }
    }

    /*
     * Creates a new directory in the selected location.
     */
    public void addChildToNode(String path, String newName) {
        File newNode = new File(path, newName);
        newNode.mkdir();
    }

    /*
     * Menu for finding a ceratin file.
     */
    public void findMenu(LCRSNode root) {
        System.out.println("Please enter the name of the node to find.");
        String fileToFind = sc.nextLine();
        LCRSNode node = findNode(root, fileToFind);
        if (node != null) { // If we find the node
            System.out.println("Node found: " + node.getPath());
            File parentFile = new File(node.getPath());
            if (!parentFile.isDirectory()) { // If the node is a file, we cannot add children
                System.out.println("Selected node is a directory and cannot have children nodes, please try again.");
                findMenu(root);
            } else { // If node is a directory, we continue
                System.out.println("Enter the name of the child folder to add:");
                String childName = sc.nextLine();
                LCRSNode child = new LCRSNode(childName);
                child.setPath(node.getPath() + "/" + childName);
                File childFile = new File(node.getPath(), childName);
                addChild(node, child);

                if (!childName.contains(".")) { // If the new node doesn´t contain any dot (.), it makes the node a directory
                    childFile.mkdir();
                }
                
                try { // File creation
                    boolean fileCreated = childFile.createNewFile();
                    if (fileCreated) {
                        System.out.println("File successfully created!");
                    } else {
                        System.out.println("File already exists or could not be created.");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred while creating the file: " + e.getMessage());
                }
            }
        } else {
            System.out.println("File could not be found, please try again.");
            findMenu(root);
        }
    }

    /*
     * The method for finding and returning the desired node.
     */
    public LCRSNode findNode(LCRSNode parent, String fileName) {
        if (parent.getKey().equals(fileName)) {
            return parent;
        }
        if (parent.getLeft() != null) {
            LCRSNode left = findNode(parent.getLeft(), fileName);
            if (left != null) {
                return left;
            }
        }
        if (parent.getRight() != null) {
            LCRSNode right = findNode(parent.getRight(), fileName);
            if (right != null) {
                return right;
            }
        }
        return null;
    }

}
