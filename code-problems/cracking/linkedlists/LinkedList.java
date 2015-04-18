/* * * * * * * * * * * * * * * * * * 
 * A LinkedList of integers
 * * * * * */

import java.util.*;

public class LinkedList {
    
    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        size = 0;
        head = null;
    }

    /* * * * * * * * * * * * * * * * * * * * * 
     * Construct a linked list from an array.
     * * * * * * * * * * * */
    public LinkedList(int[] array) {
        if (array.length == 0) { size = 0; head = null; }
        else {
            head = new Node(array[0]);
            size++;
            Node current = head;

            for (int i = 1; i < array.length; i++) {
                current.next = new Node(array[i]);
                current = current.next;
                size++;
            }
        }
    }

    public Node getHead() {
        return head; 
    }

    public void append(int i) {
        Node end = new Node(i);
        
        // handle case if head is empty
        if (head == null) {
            head = end; 
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = end;
        }
        size++;
    }

    public void print() {
        Node current = head;
        System.out.print("[");
        while (current != null) {
            if (current.next == null) System.out.print(current.data);
            else System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.printf("] Size %d \n", size);
    }

    /* * * * * * * * * * * * * * * * * * * * *
     * Remove duplicates from the linked list.
     * * * * * * * * * * */
    public void removeDuplicates() {
       
        // a set with one or less elements cannot contain duplicates
        if (this.size <= 1) return; 
        
        HashSet<Integer> set = new HashSet<Integer>(); 

        // traverse the list and populate a set, which can't contain duplicates
        Node current = head; 
        while (current != null) {
            set.add(current.data);
            current = current.next;
        }
        
        // build a new linked list with no duplicates
        int[] array = new int[set.size()];
        size = 0; 
        for (Integer i : set) {
            array[size] = i;
            size++;
        }

        LinkedList list = new LinkedList(array);
        head = list.getHead();
    }

    /* * * * * * * * * * * * * * * * * * * * * * *
     * Remove all nodes with the given data item.
     * * * * * * */
    public void deleteNode(int d) {

        Node current = head;
        Node next = current.next;

        // notice that we skip the first node
        while (next != null) {
            if (next.data == d) { // delete this node
                current.next = next.next;
                next = next.next;
                size--;
            } else { // otherwise, move past it
                current = current.next;
                next = next.next;
            }
        }

        // delete first node if we need to 
        if (head.data == d) {
            head = head.next;
            size--;
        }
       
    }

    public static void main(String[] args) {
        int[] array = {10, 10, 10, 1, 1, 2, 23, 23, 10, 1, 25};
        LinkedList list = new LinkedList(array);
        list.deleteNode(10);
        list.print();
    }
}
