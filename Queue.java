/*******************************************
 * Written by Tarif Haque on 31 Jan 2013
 * CS 360 Data Structures & Algorithms
 * Project 2
 * 
 * A Queue implemented as a linked list used
 * in CostBasisCalculator.
 *******************************************/

public class Queue {
	
	/* A Node in a Queue contains a data object and
	 * a reference to the next queued node. */
	private class Node {
		Object data;
		Node next;
		Node (Object x, Node q) {data = x; next = q;}
	}
	
	/* Attributes of a Queue.*/
	private Node front, back;
	private int size;
	
	/* The Initial Queue. */
	public Queue() {
		front = null; back = null;
		size = 0;
	}
	
	/* Add an Object to the Queue. */
	public void enqueue(Object x) {
		Node newNode = new Node(x, null);
		if (isEmpty()) front = newNode;
		else back.next = newNode;
		back = newNode;
		size++;
	}

	/* Dequeue an element from the Queue. */
	public Object dequeue() {
		if (isEmpty()) {
			try { throw new Exception();} 
			catch (Exception e) { System.out.println("Cannot dequeue from an empty queue.");}
		}
		
		Object x = front.data;
		front = front.next;
		if (front == null) back = null;
		size = size - 1;
		return x;
	}
	
	/* Not a traditional queue method.
	 * SetFront() allows the data in the front
	 * node to be reset. */
	public void SetFront(Object x) {
		front.data = x;
	}
	
	/* Look at the next object to be dequeued. */
	public Object ExamineFront() {
		return (front.data);
	}
		
	/* Is the Queue empty? */
	public boolean isEmpty() {
		if (front == null) return true;
		else return false;
	}
	
	/* Return size of Queue. */
	int getSize() {return size;}
}