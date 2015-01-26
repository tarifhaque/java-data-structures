public class MinAndMax {

    /*
        Given an array of size n, return an array of 4 elements
        that consists of the smallest, second smallest, second largest,
        and largest elements in the array.

        Using a divide and conquer approach with the recurrence
        T(n) = 2 T(n/2) + O(1)
     */
    public static int[] minmaxtuple(int[] array, int low, int high) {
        if (low == high) {
            int[] thing = {array[low], Integer.MAX_VALUE, Integer.MIN_VALUE, array[high]};
            return thing;
        }
        int mid = (low + high) / 2;

        // find the minmaxtuple of the left half
        int[] left = minmaxtuple(array, low, mid);

        // find the minmaxtuple of the right half
        int[] right = minmaxtuple(array, mid + 1, high);

        int[] merged = merge(left, right);
        int[] four = {merged[0], merged[1], merged[merged.length - 2], merged[merged.length - 1]};
        return four;
    }

    /* Merge two sorted arrays. */
    private static int[] merge(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];

        int aCount = 0;
        int bCount = 0;
        int i = 0;

        while (true) {
            if (a[aCount] < b[bCount]) {
                merged[i] = a[aCount];
                aCount++;
            } else {
                merged[i] = b[bCount];
                bCount++;
            }
            i++;
            if (aCount == a.length || bCount == b.length) break;
        }

        while (i != merged.length) {
            if (aCount == a.length) {
                merged[i] = b[bCount];
                bCount++;
            } else {
                merged[i] = a[aCount];
                aCount++;
            }
            i++;
        }

        return merged;
    }

}
