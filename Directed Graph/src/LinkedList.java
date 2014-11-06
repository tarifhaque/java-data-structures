public class LinkedList<Type> {

	class Node {
		Type data;
		Node next;
		Node prev;

		Node(Type dataEntry, Node nextNode, Node prevNode) {
			data = dataEntry;
			next = nextNode;
			prev = prevNode;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	LinkedList() {
		head = new Node(null, tail, null);
		tail = new Node(null, null, head);
		size = 0;
	}

	public int size() {
		return size;
	}

	/* return the first data entry. */
	public Type getFirst() {
		return head.next.data;
	}

	/* return the first node. */
	public Node first() {
		return head.next;
	}

	/* return the last node. */
	public Node last() {
		return tail.prev;
	}

	/* return data entry at an index. */
	public Type get(int index) {
		Node x = head.next;
		for (int r = 0; r != index; r += 1)
			x = x.next;
		return x.data;
	}

	/* add a data entry to the end of the list. */
	public void add(Type x) {
		Node newNode = new Node(x, tail, tail.prev);
		tail.prev.next = newNode;
		tail.prev = newNode;
		size++;
	}

	/* remove data entry at an index. */
	public void remove(int index) {
		// first get to index i
	}

	/* remove an entry in the list. */
	public void remove(Type value) {
		Node x = head.next;
		for (int r = 0; r != size(); r += 1) {
			if (x.data == value) {
				x.next.prev = x.prev;
				x.prev.next = x.next;
			}
			x = x.next;
		}
		size--;
	}

	/* insert a data entry at an index. */
	public void insert(int index, Type value) {
		Node x = head.next;
		for (int r = 0; r != index; r += 1)
			x = x.next;
		Node newNode = new Node(value, x, x.prev);
		x.prev.next = newNode;
		x.prev = newNode;
		size++;
	}

	/* clear the linked list of all nodes. */
	public void clear() {
		head = new Node(null, tail, null);
		tail = new Node(null, null, head);
		size = 0;
	}

	/*
	 * return the index of a data entry in the linked list. return -1 if not
	 * found.
	 */
	public int indexOf(Type value) {
		Node x = head.next;
		for (int r = 0; r != size(); r += 1) {
			if (x.data == value) return r;
			x = x.next;
		}
		return -1;
	}
}
