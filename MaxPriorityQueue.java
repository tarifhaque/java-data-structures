/**********************************************
 * Objects stored in this MinPriorityQueue must
 * extend the interface Comparable and 
 * implement the compareTo method. 
 *
 * CS 360 Data Structures & Algorithms
 ***********************************************/

import java.util.*;
public class MaxPriorityQueue<TYPE extends Comparable<TYPE>> {
	
	private ArrayList<TYPE> elements;
	
	public MaxPriorityQueue() {
		elements = new ArrayList<TYPE>();
	    elements.add(null); 
	}
	
	public void add(TYPE newElement)
	{
	      // Add a new leaf
	      elements.add(null);
	      int index = elements.size() - 1;
	      
	      // Demote parents that are smaller than the new element
	      while (index > 1 
	            && getParent(index).compareTo(newElement) < 0) 
	      {
	         elements.set(index, getParent(index));
	         index = getParentIndex(index);
	      }
	
	      // Store the new element into the vacant slot
	      elements.set(index, newElement);
	 }
	
	public TYPE remove()
	   {
	      TYPE maximum = elements.get(1);      

	      // Remove last element
	      int lastIndex = elements.size() - 1;
	      TYPE last = elements.remove(lastIndex);

	      if (lastIndex > 1)
	      {
	         elements.set(1, last);
	         fixHeap();     
	      }

	      return maximum;
	   }
	
	private void fixHeap() {
		TYPE root = elements.get(1);

      int lastIndex = elements.size() - 1;
      // Promote children of removed root while they are smaller than last      

      int index = 1;
      boolean less = true;
      while (less)
      {
         int childIndex = getLeftChildIndex(index);
         if (childIndex <= lastIndex) // Get larger child 
         {
            // Get left child first
            TYPE child = getLeftChild(index);

            // Use right child instead if it is greater
            if (getRightChildIndex(index) <= lastIndex 
                  && getRightChild(index).compareTo(child) > 0)
            {
               childIndex = getRightChildIndex(index);
               child = getRightChild(index);
            }

            // Check if larger child is greater than root
            if (child.compareTo(root) > 0) 
            {
               // Promote child
               elements.set(index, child);
               index = childIndex;
            }
            else
            {
               // Root is greater than both children
               less = false;
            }
         }
         else 
         {
            // No children
            less = false; 
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