import java.util.LinkedList;

/*****************************************
 * Tree.java 
 * Project 3 
 * CS 360 - Data Structures and Algorithms 
 * 
 * Written by Tarif Haque on 
 * February 15 2013
 *****************************************/

public class Tree {
	
	/* represents a single node in the tree */
	class Node {
		int label;
		Node leftMostChild, rightMostChild;
		Node leftSibling, rightSibling;
		Node parent;
		boolean isLeaf;
	}
	
	Node root; // the root of the tree
	Node currentNode; // the current node of the tree
	int size; // the size of the tree
	
	/* constructor for an empty tree */
	Tree() {
		root = new Node();
		root.label = 0;
		size = 1; 
		root.isLeaf = true;
		currentNode = root;
	}

	/* returns the number of nodes in this tree */
	public int size() {
		return size;
	}

	/* return the label of the current node */
	public int label() {
		return currentNode.label;
	}

	/* change the label of the current node to x */
	public void replaceLabel(int x) {
		currentNode.label = x;
	}

	/* give the current node a new leftmost child with label x */
	public void addLeftmostChild(int x) {
		Node newLeftmostChild = new Node(); // the new left most child to be added 
		Node previousLeftmostChild = currentNode.leftMostChild; // the previous left most child of the current node
		
		newLeftmostChild.parent = currentNode;
		newLeftmostChild.label = x;
		
		if (currentNode.leftMostChild != null) {
			newLeftmostChild.rightSibling = previousLeftmostChild;
			previousLeftmostChild.leftSibling = newLeftmostChild;
		} else {
			// if the current node does not have a left most child, 
			// then when a left most child is added, the current node's
			// right most child will be it's left most child.
			currentNode.rightMostChild = newLeftmostChild; 
		}
		
		newLeftmostChild.isLeaf = true; // when a new node is added, it is a leaf
		newLeftmostChild.parent.isLeaf = false; // however, its parent is no longer a leaf
		currentNode.leftMostChild = newLeftmostChild;
		size++;
	}

	/* give the current node a new leftmost child with label x */
	public void addRightmostChild(int x) {
		Node newRightmostChild = new Node(); // the new right most child to be added
		Node previousRightmostChild = currentNode.rightMostChild; // the previous right most child of the current node
		
		newRightmostChild.parent = currentNode;
		newRightmostChild.label = x;
		
		if (currentNode.rightMostChild != null) {
			newRightmostChild.leftSibling = previousRightmostChild;
			previousRightmostChild.rightSibling = newRightmostChild;
		} else {
			// if the current node does not have a right most child, 
			// then when a right most child is added, the current node's
			// left most child will be it's right most child.
			currentNode.leftMostChild = newRightmostChild;
		}
		
		newRightmostChild.isLeaf = true; // when a new node is added, it is a leaf
		newRightmostChild.parent.isLeaf = false; // however, its parent is no longer a leaf
		currentNode.rightMostChild = newRightmostChild;
		size++;
	}

	/* return true if current node is the root, otherwise return false */
	public boolean isRoot() {
		if (currentNode.parent == null) {return true;}
		return false;
	}

	/* return true if current node is a leaf, otherwise return false */
	public boolean isLeaf() {
		return currentNode.isLeaf;
	}

	/* set current node to the root */
	public void gotoRoot() {
		currentNode = root;
	}

	/* set current node to the parent of current node, if it exists */
	public void gotoParent() {
		if (currentNode.parent != null) 
			currentNode = currentNode.parent;
	}

	/* set current node to the leftmost child of current node, if it exists */
	public void gotoLeftmostChild() {
		if (currentNode.leftMostChild != null)
			currentNode = currentNode.leftMostChild;
	}

	/* set current node to the rightmost child of current node, if it exists */
	public void gotoRightmostChild() {
		if (currentNode.rightMostChild != null)
			currentNode = currentNode.rightMostChild;
	}

	/* set current node to the immediate left sibling of current node, if it exists */
	public void gotoLeftSibling() {
		if (currentNode.leftSibling != null)
			currentNode = currentNode.leftSibling;
	}

	/* set current node to the immediate right sibling of current node, if it exists */
	public void gotoRightSibling() {
		if (currentNode.rightSibling != null)
			currentNode = currentNode.rightSibling;
	}

	/* print the labels of all nodes using a pre-order traversal */
	public void preOrder() {
		System.out.print("Preorder Traversal:");
		preOrder(root);
		System.out.println();
	}

	private void preOrder(Node pNode) {
		if (pNode == null) return;
		System.out.print(" " + pNode.label); // visit the node
		preOrder(pNode.leftMostChild);
		preOrder(pNode.rightSibling);
	}

	/* print the labels of all nodes using a post-order traversal */
	public void postOrder() {
		System.out.print("Postorder Traversal:");
		postOrder(root);
		System.out.println();
	}

	private void postOrder(Node pNode) {
		if (pNode == null) return;
		postOrder(pNode.leftMostChild);
		System.out.print(" " + pNode.label); // visit the node
		postOrder(pNode.rightSibling);
	}

	/* print the labels of all nodes using a level-order traversal */
	public void levelOrder() {
		// simulate a level order traversal using a queue
		LinkedList<Tree.Node> queue = new LinkedList<Tree.Node>();
		queue.add(root);
		System.out.print("Level Order Traversal:");
		while (!queue.isEmpty()) {
			Node pNode = queue.remove();
			System.out.print(" " + pNode.label); // visit the node
			for (Node c = pNode.leftMostChild; c != null; c = c.rightSibling) {
				queue.add(c);
			}
		}
		System.out.println();
	}
}