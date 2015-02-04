/* * * * * * * * * * * * * * * * * * * * 
 * BinaryTree.java
 *
 * In this BinaryTree, all elements in the left subtree
 * of a Node are less than or equal to data in the 
 * Node. Conversely, all elements in the right subtree
 * of a Node are greater than data in the Node.
 *
 * See: http://cslibrary.stanford.edu/110/BinaryTrees.html#java
 * * * * * * * * * * * * * * * * * * * * */

public class BinaryTree {
   
    private static class Node {
        int data;
        Node left;
        Node right;
        
        /* Node constructor */
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    /* Reference to root node. Null for empty tree. */
    private Node root;

    /* Create an empty binary tree.*/
    public BinaryTree() {
        root = null;
    }

    private Node insert(Node node, int data) {
        // Base case: if node is empty, return new node with data
        if (node == null) {
            node = new Node(data);
        } 

        else { // recur down the tree
          if (data <= node.data) {
            node.left = insert(node.left, data);
          } else {
            node.right = insert(node.right, data);
          }
       }

        // in any case, return reference to caller
        return(node);
    }

    public void insert(int data) {
       root = insert(root, data);
    }

    /* * * * * * * * * * * * * * * * * * * * * * *
     * Recursive helper method that prints
     * the tree in preorder fashion.
     *
     * Visit current node, then traverse
     * left subtree, then traverse right subtree;
     * * * * * * * * * * * * * * * * * * * * * * */ 
    private void preorder(Node root) {
        if (root == null) return;
        else {
            // Print the current node
            System.out.print(Integer.toString(root.data) + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void preorder() {
        preorder(this.root);
        System.out.println();
    }

}
