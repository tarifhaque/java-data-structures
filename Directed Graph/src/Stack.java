/*******************************************
 * Written by Tarif Haque on 31 Jan 2013
 * CS 360 Data Structures & Algorithms
 * Project 2
 * 
 * A Stack implemented as a linked list used
 * in CostBasisCalculator.
 *******************************************/

public class Stack {
	
	/* A Node in a Stack contains a data
	 * object and a reference to the next node. */
	private class Node {
		Object data; Node next;
		Node (Object x, Node nextNode) {
			data = x; next = nextNode;
		}
	}
	
	/* Attributes of a Stack. */
	private Node top;
	private int size;
	
	/* The initial Stack. */
	public Stack() {
		top = null;
		size = 0;
	}
	
	/* Push an Object onto the Stack. */
	public void push(Object x) {
		top = new Node(x, top);
		size++;
	}
	
	/* Pop an Object off the Stack. */
	public Object pop() {
		if (isEmpty()) {
			try { throw new Exception();} 
			catch (Exception e) { System.out.println("Cannot pop from an empty stack.");}
		}
		
		Object x = top.data;
		top = top.next;
		size = size - 1;
		return x;
	}

	/* Is the Stack empty? */
	public boolean isEmpty() {
		if (size == 0) return true;
		else return false;
	}
	
	/* Examine the top of the Stack. */
	public Object top() {
		if (isEmpty()) {
			try { throw new Exception();} 
			catch (Exception e) { System.out.println("Cannot examine the top of an empty stack.");}
		}
		
		return top.data;
	}
	
	/* Return the size of the Stack. */
	int size() {return size;}

	/* Return the size of the Stack. */
	public int getSize() { return size; }

	/* Not a traditional Stack method. */
	public void SetFront(Object x) {
		top.data = x;
	}
}