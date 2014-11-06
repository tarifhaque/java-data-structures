/**********************************************
 * Objects stored in this MinPriorityQueue must
 * extend the interface Comparable and 
 * implement the compareTo method. 
 *
 * CS 360 Data Structures & Algorithms
 ***********************************************/

import java.util.*;
public class MinPriorityQueue<TYPE extends Comparable<TYPE>> {
	
	private ArrayList<TYPE> elements;
	
	
	public MinPriorityQueue() {
		elements = new ArrayList<TYPE>();
	    elements.add(null); 
	}
	
	public void add(TYPE newElement)
	{
	      // Add a new leaf
	      elements.add(null);
	      int index = elements.size() - 1;
	      
	      // Demote parents that are larger than the new element
	      while (index > 1 
	            && getParent(index).compareTo(newElement) > 0) 
	      {
	         elements.set(index, getParent(index));
	         index = getParentIndex(index);
	      }
	
	      // Store the new element into the vacant slot
	      elements.set(index, newElement);
	 }
	
	public TYPE remove()
	   {
	      TYPE minimum = elements.get(1);      

	      // Remove last element
	      int lastIndex = elements.size() - 1;
	      TYPE last = elements.remove(lastIndex);

	      if (lastIndex > 1)
	      {
	         elements.set(1, last);
	         fixHeap();     
	      }

	      return minimum;
	   }
	
	private void fixHeap() {
		TYPE root = elements.get(1);

      int lastIndex = elements.size() - 1;
      // Promote children of removed root while they are larger than last      

      int index = 1;
      boolean more = true;
      while (more)
      {
         int childIndex = getLeftChildIndex(index);
         if (childIndex <= lastIndex)
         {
            // Get smaller child 

            // Get left child first
            TYPE child = getLeftChild(index);

            // Use right child instead if it is smaller
            if (getRightChildIndex(index) <= lastIndex 
                  && getRightChild(index).compareTo(child) < 0)
            {
               childIndex = getRightChildIndex(index);
               child = getRightChild(index);
            }

            // Check if larger child is smaller than root
            if (child.compareTo(root) < 0) 
            {
               // Promote child
               elements.set(index, child);
               index = childIndex;
            }
            else
            {
               // Root is smaller than both children
               more = false;
            }
         }
         else 
         {
            // No children
            more = false; 
         }
      }

      // Store root element in vacant slot
      elements.set(index, root);
	}

	private int getRightChildIndex(int index) {
		return 2 * index + 1;
	}

	private TYPE getLeftChild(int index) {
		return elements.get(2 * index);
	}
	
	private TYPE getRightChild(int index) {
		return elements.get(2 * index + 1);
	}

	private int getLeftChildIndex(int index) {
		return 2 * index;
	}

	public TYPE peek() {
		return elements.get(1);
	}

	private int getParentIndex(int index) { 
		return index/2;
	}
	
	private TYPE getParent(int index) {
		return elements.get(index/2);
	}

	public int size() {
		return elements.size();
	}
}