public class BinarySearch {

    /*
       Search for int x in sorted array.
       The classical binary search. Simple illustration of the
       divide and conquer approach.

       Return index of searched int if found.
       Otherwise, return -1. (Assume all elements in sorted array are positive.)
       Calls a private helper method.
     */
    public static int binarysearch(int x, int[] sortedarray) {
        return binarysearch(x, sortedarray, 0, sortedarray.length - 1);
    }

    private static int binarysearch(int x, int[] sortedarray, int low, int high) {
        // return -1 if not found
        if (low > high) return -1;
        int mid = (low + high) / 2;

        // we found it!
        if (sortedarray[mid] == x) return mid;

        // recursively search right half of array
        else if (sortedarray[mid] < x)
            return binarysearch(x, sortedarray, mid + 1, high);

        // recursively search left half of the array
        else
            return binarysearch(x, sortedarray, low, mid - 1);
    }

}



