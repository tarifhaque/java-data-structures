import java.lang.Math;

public class NumberStack {

    class Node {
        int data;
        Node next;

        public Node(int number) {
            this.data = number; 
        }
    }

    Node top;
    int size;

    public NumberStack() {
        top = null;
        size = 0;
    }

    public void push(int number) {
        Node node = new Node(number);
        node.next = top;
        top = node;
        size++;
    }

    public Integer peek() {
        if (size > 0) return top.data;
        else return null;
    }

    public Integer  pop() {
        if (size > 0) {
            Node node = top;
            top = top.next;
            return node.data;
        }

        return null;
    }

    public void print() {
        Node start = top;
        System.out.print("TOP > ");
        if (size == 0) System.out.print("(empty stack) ");
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
        System.out.println("< END");
    }

    public static void main(String[] args) {
        NumberStack stack = new NumberStack();
        
        for (int i = 0; i < 10; i++) {
            int x = (int) Math.floor(Math.random() * 100);
            stack.push(x);
        }

        stack.print();
    }

}
