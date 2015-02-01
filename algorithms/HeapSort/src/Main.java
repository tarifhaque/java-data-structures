public class Main {

    public static void main(String[] args) {
        Integer[] array = {10, 16, 14, 8, 7, 9, 3, 2, 4, 1};
        MaxHeap<Integer> heap = new MaxHeap<Integer>(array);
        heap.printHeap();
    }

}
