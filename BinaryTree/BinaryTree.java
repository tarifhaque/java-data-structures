/* * * * * * * * * * * * * * * * * * * * 
 * BinaryTree.java
 * Last revised 3 Feb 2015 by Tarif Haque
 *
 * In this BinaryTree, all elements in the left subtree
 * of a Node are less than or equal to data in the 
 * Node. Conversely, all elements in the right subtree
 * of a Node are greater than data in the Node.
 * 
 * For original source see: 
 * http://cslibrary.stanford.edu/110/BinaryTrees.html#java
 * * * * * * * * * * * * * * * * * * * * */

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

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

        public String string() {
            return Integer.toString(data);
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
            System.out.print(root.string() + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

   /* * * * * * * * * *
    * Inorder traversal (symmetric)
    *
    * Recursively traverse left subtree, visit current node,
    * then traverse right subtree.
    * * */
    private void inorder(Node root) {
        if (root == null) return;
        else {
            inorder(root.left);
            System.out.print(root.string() + " ");
            inorder(root.right);
        }
    }

    /* * * * * * * * * * * * 
     * Postorder traversal
     *
     * Recursively traverse the left subtree, then traverse right
     * subtree, and finally, visit the current node.
     * * * * * */
    private void postorder(Node root) {
        if (root == null) return;
        else {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.string() + " ");
        }
    }

    /* * * * * * * * * * * * * * * * * *
     * Breadth first : visit every node
     * on a level before going to a lower
     * level.
     * * * * * * * * */
    private void levelorder(Node root) {

        // Create a queue of Nodes 
        Queue<Node> queue = new LinkedList<Node>();

        // Enqueue the root node, to start
        queue.add(root); 

        while (queue.size() != 0) {
            Node examined = queue.remove();
            System.out.print(examined.string() + " ");

            // Enqueue examined node's sucessors
            if (examined.left != null) queue.add(examined.left);
            if (examined.right != null) queue.add(examined.right);
        } 

    }

    public void preorder() {
        System.out.print("Preorder traversal: ");
        preorder(this.root);
        System.out.println();
    }

    public void inorder() {
        System.out.print("Inorder traversal: ");
        inorder(this.root);
        System.out.println();
    }

    public void postorder() {
        System.out.print("Postorder traversal: ");
        postorder(this.root);
        System.out.println();
    }

    public void levelorder() {
        System.out.print("Level order traversal: ");
        levelorder(this.root);
        System.out.println();
    }

    private void populateElements(ArrayList<Integer> elements, Node root) {
        if (root == null) {
            return;
        } else {
            populateElements(elements, root.left);
            elements.add(root.data);
            populateElements(elements, root.right);
        }
    }

    public void printInorder() {
        ArrayList<Integer> elements = new ArrayList<Integer>();
        populateElements(elements, this.root);
        System.out.println("Sorted (in-order): " + elements.toString());
    }

    public double findMedian() {
        ArrayList<Integer> elements = new ArrayList<Integer>();
        populateElements(elements, this.root);

        int size = elements.size();
        
        // return -1 if list is empty e.g. median does not exist 
        if (size == 0) return -1;

        int mid = size / 2;

        // if odd number elements, return middle element
        if (size % 2 == 1) return elements.get(mid);

        // else, return average of middle two elements
        else return (elements.get(mid) + elements.get(mid - 1)) / 2.0;
    }
}
