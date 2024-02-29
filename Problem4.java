import java.util.Iterator;

public class Problem4 {

    public static void main(String[] args) {
        BST t = new BST();
        // Adding a bunch of numbers to the tree
        t.add(5);
        t.add(3);
        t.add(4);
        t.add(9);
        t.add(6);
        t.add(7);
        t.add(8);
        t.add(2);
        t.add(1);

        // Printing size, hight and wheather it contains 7
        System.out.println("Size: " + t.size());
        System.out.println("Height: " + t.height());
        System.out.println("Does it contain the number 7? " + t.contains(7));

        // Using the general iterator method. Changeable in the BST class at the bottom.
        // Comment in/out which type of iterator to use.
        Iterator<Integer> it = t.iterator();
        System.out.print("General iteration method: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // Iterate over the tree inorder (specific method)
        Iterator<Integer> inOrder = t.iteratorInorder();
        System.out.print("\nInorder: ");
        while (inOrder.hasNext()) {
            System.out.print(inOrder.next() + " ");
        }

        // Iterate over the tree preorder (specific method)
        Iterator<Integer> preOrder = t.iteratorPreorder();
        System.out.print("\nPreorder: ");
        while (preOrder.hasNext()) {
            System.out.print(preOrder.next() + " ");
        }

        // Iterate over the tree postorder (specific method)
        Iterator<Integer> postOrder = t.iteratorPostorder();
        System.out.print("\nPostorder: ");
        while (postOrder.hasNext()) {
            System.out.print(postOrder.next() + " ");
        }

        // Remove kth largest and verifying that is has been removed by iterating over the elements inorder.
        System.out.println();
        t.removeKthLargest(4);
        Iterator<Integer> inOrderAfterRemoval = t.iteratorInorder();
        System.out.print("Inorder after removing the kth largest: ");
        while (inOrderAfterRemoval.hasNext()) {
            System.out.print(inOrderAfterRemoval.next() + " ");
        }
        
    }
}
