/***********************************************
 * Implementing a Generic Heap, for kicks.
 * Excellent psuedocode from Algorithms (Cormen).
 *
 * Tarif Haque
 ***********************************************/

public class MaxHeap<Type extends Comparable<Type>> {

    final static int DEFAULT_SIZE = 100;
    int numberElements = 0;

    // Elements in heap begin at index 1
    Type[] heap;

    public MaxHeap(Type[] array) {

        if (array.length != 0) {
            heap = (Type[]) new Object[DEFAULT_SIZE];
            heap[0] = null;
            for (int i = 1; i <= array.length; i++) {
                heap[i] = array[i - 1];
                numberElements++;
            }
        } else {
            heap = (Type[]) new Object[DEFAULT_SIZE];
            heap[0] = null;
            numberElements = 0;
        }

    }

    public MaxHeap() {
        heap = (Type[]) new Object[DEFAULT_SIZE];
        heap[0] = null;
        numberElements = 0;
    }

    /****************************************************
     * Assuming a node at index i, return the left, right,
     * or parent node of that node.
     ****************************************************/
    private int left(int index) {return 2 * index;}

    private int right(int index) {return (2 * index) + 1;}

    private int parent(int index) {return index / 2;}

    /***********************************************
     * Assume binary trees rooted at left[i] and
     * right[i] are max heaps; however, array[i] may
     * be smaller than its children, so "float it"
     * down.
     ***********************************************/
    public void maxHeapify(Type[] array, int i) {

        int largest;
        int left = left(i);
        int right = right(i);


    }

    public void printHeap() {

        for (int i = 1; i <= numberElements; i++) {
            System.out.printf("%s ", heap[i] + " ");
            int breakline = (int) Math.pow(2, i);
            if (i == breakline) System.out.println();
        }
    }

}
