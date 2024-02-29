Hello!

Edit:
Problem 2 and 4 had incorrectly implemented iterators. This should not be fixed so that we use the proper way of iterating over elements.

The files in this ZIP are the code, the report, visalization (python) and DummyDir directories for Problem 3.
Problem 3 is pre-set to use the files and multi layer folders within DummyDir. Please use this, or change the path variable in P3 accordingly.
For the find a node-part of problem 3, make sure that the method findMenu() isn´t commented out. 
This method takes a string input from the user, searches all subtrees for a node with such a name, using the findNode() method in the PathTree class. 
This method returns the node, and if it is a directory, a child can be added to it using another string input from the user. If the node doesn´t exist,
the program asks the user to try again. If the input for the new child doesn´t contain a dot (.), it creates a directory, otherwise it creates a file type 
according to the of input.
NOTE for P6: The AVL using 1 million operation takes very long time. You can comment it out (or run fewer operations) if you don´t have the time, the result is a balanced tree, regardless of how many operations are made. Just make sure that the BST runs for that many operations, otherwise the height remains roughly the same.

Several of the nodes could be re-used for different problems, but I have separated them into different classes.

To run the code, make sure the files are in the same folder and run them through your IDE. Also make sure to open the entire folder in the IDE to access the other classes (can be done using the command "code ." in git bash, while located in this folder). I have been using VSCode for the development.

The following classes are used in the different tasks.

P1:
- Problem1.java
- Deque.java
- DQIterator.java

P2:
- Problem2.java
- RandomQueue.java
- RQIterator.java

P3:
- Problem3.java
- LCRSNode.java
- PathTree.java

P4:
- Problem4.java
- BST.java
- BSTNode.java
- BSTIteratorInorder.java
- BSTIteratorPreorder.java
- BSTIteratorPostorder.java

P5:
- Problem5.java
- IsoNode.java

P6:
- Problem6.java
- TimeMeasuring.java
- AVLtree.java
- AVLNode.java
- BST.java
- BSTNode.java
- AVLIterator.java
- BSTIteratorPreorder.java
- Vis_hist.py
