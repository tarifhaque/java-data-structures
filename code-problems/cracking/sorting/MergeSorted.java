import java.util.Arrays;

public class MergeSorted {

    /* * * * * * * * * * * * * * 
     * n = # of elements in A[] and m = # of elements in B[] 
     * Assume A[] and B[] are sorted 
     * A[] has enough "buffer" at the end to store elements in B[]
     * * * * * * * */
    public static int[] merge(int[] A, int[] B, int n, int m) {
        int aTop = n - 1;
        int bTop = m - 1;

        int i = n + m - 1;

        for (i = n + m - 1; i >= 0; i--) {
            if (aTop == -1 || bTop == -1) break;
            if (A[aTop] > B[bTop]) {
                A[i] = A[aTop];
                aTop--;
            } else {
                A[i] = B[bTop];
                bTop--;
            }
        }

        // if we've run out of elements to place in A
        if (aTop == -1) {
            for (int j = i; j >= 0; j--) {
                A[j] = B[bTop];
                bTop--;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 15, 35, 50};  
        int[] b = {1, 2, 5, 6, 13, 20, 30, 40, 50, 60};

        int[] aBuffered = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) aBuffered[i] = a[i];

        int[] result = merge(aBuffered, b, a.length, b.length);

        System.out.println("A: " + Arrays.toString(a));
        System.out.println("B: " + Arrays.toString(b));
        System.out.println("Merged: " + Arrays.toString(result));
    }

}
