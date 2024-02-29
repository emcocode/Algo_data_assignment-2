import java.util.Arrays;
import java.util.Random;

public class Problem6 {
    
    public static void main(String[] args) {
        Random rn = new Random();
        TimeMeasuring timer = new TimeMeasuring();
        int ops = 1000000;
        int trees = 100;
        int totBSTHeight = 0, totAVLHeight = 0, totBSTSize = 0, totAVLSize = 0;
        long addAVLTime = 0, addBSTTime = 0, rmAVLTime = 0, rmBSTTime = 0, findBSTTime = 0, findAVLTime = 0;
        int[] heightListAVL = new int[trees], sizeListAVL = new int[trees];
        int[] heightListBST = new int[trees], sizeListBST = new int[trees];
        for (int j = 0; j < trees; j++) {
            System.out.println("Building tree: " + (j+1));
            AVLTree avl = new AVLTree();
            BST bst = new BST();
            RandomQueue rq = new RandomQueue(); // We use the randomqueue to keep track of what to remove
            while (bst.size() < 1023) { // Building the trees
                int k = rn.nextInt(100000);
                bst.add(k);
                avl.add(k);
                rq.enqueue(k);
            }
            for (int i = 0; i < ops; i++) { // Add and remove operations
                int k = rq.dequeue(); // Remove random
                // Remove from BST
                timer.startTimer();
                bst.remove(k);
                rmBSTTime += timer.stopTimer();
                // Remove from AVL
                timer.startTimer();
                avl.remove(k);
                rmAVLTime += timer.stopTimer();

                // Add random
                k = rn.nextInt(100000);
                while (bst.contains(k)) {
                    k = rn.nextInt(100000);
                }
                rq.enqueue(k);
                // Add to BST
                timer.startTimer();
                bst.add(k);
                addBSTTime += timer.stopTimer();
                // Add to AVL
                timer.startTimer();
                avl.add(k);
                addAVLTime += timer.stopTimer();
            }

            // Find certain nodes
            for (int h = 0; h < ops; h++) {
                int k = rn.nextInt(100000);
                // Find on BST
                timer.startTimer();
                bst.find(k);
                findBSTTime += timer.stopTimer();
                // Find on AVL
                timer.startTimer();
                avl.find(k);
                findAVLTime += timer.stopTimer();

            }

            // Calculate sums and adding to lists for visualizations
            totAVLHeight += avl.getHeight();
            heightListAVL[j] = avl.getHeight();
            sizeListAVL[j] = avl.getSize();
            totAVLSize += avl.getSize();
            totBSTHeight += bst.height();
            heightListBST[j] = bst.height();
            sizeListBST[j] = bst.size();
            totBSTSize += bst.size();
            
        }

        // Getting avg times, making them doubles
        double d_addAVLTime = (double)(addAVLTime / 1000000) / (double)(ops) / trees;
        double d_addBSTTime = (double)(addBSTTime / 1000000) / (double)(ops) / trees;
        double d_rmAVLTime = (double)(rmAVLTime / 1000000) / (double)(ops) / trees;
        double d_rmBSTTime = (double)(rmBSTTime / 1000000) / (double)(ops) / trees;
        double d_findAVLTime = (double)(findAVLTime / 1000000) / (double)(ops) / trees;
        double d_findBSTTime = (double)(findBSTTime / 1000000) / (double)(ops) / trees;
        
        // Print the results
        System.out.println("TOTAL:");
        System.out.println("AVL:");
        System.out.println("\tAverage height was " + totAVLHeight/trees);
        System.out.println("\tAverage size " + totAVLSize/trees);
        System.out.println("\tAverage time per add: " + d_addAVLTime + " ms.");
        System.out.println("\tAverage time per remove: " + d_rmAVLTime + " ms.");
        System.out.println("\tAverage time per find: " + d_findAVLTime + " ms.");

        System.out.println("BST:");
        System.out.println("\tAverage height was " + totBSTHeight/trees);
        System.out.println("\tAverage size " + totBSTSize/trees);
        System.out.println("\tAverage time per add: " + d_addBSTTime + " ms.");
        System.out.println("\tAverage time per remove: " + d_rmBSTTime + " ms.");
        System.out.println("\tAverage time per find: " + d_findBSTTime + " ms.");

        System.out.println("AVL heightlist: " + Arrays.toString(heightListAVL));
        System.out.println("AVL sizelist: " + Arrays.toString(sizeListAVL));
        System.out.println("BST heightlist: " + Arrays.toString(heightListBST));
        System.out.println("BST sizelist: " + Arrays.toString(sizeListBST));
    }
}
