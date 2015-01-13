 /* *
 * An implementation of MergeSort in Java.
 * Because it's my favorite sorting algorithm.
 *
 * Written by Tarif Haque
 * Last Revised: 1/10/2015
 * */ 

import java.lang.Math;
import java.util.*;

public class MergeSort {
  
  /* Print a given integer array to terminal. */
  private static void printarray(int[] array) {
    System.out.print("[");
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
      if (i != array.length - 1) System.out.print(", ");
    }
    System.out.print("] \n");
  }
  
  private static int[] mergesort(int[] array) {
      // a list of zero or one elements is sorted
      if (array.length <= 1) return array;

      // divide list into equal-sized sublists
      int mid = array.length / 2;
      int[] left = Arrays.copyOfRange(array, 0, mid);
      int[] right = Arrays.copyOfRange(array, mid, array.length);

      int[] leftsorted = mergesort(left);
      int[] rightsorted = mergesort(right);

      // recursively sort left and right arrays
      return merge(leftsorted, rightsorted); 
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

  public static void main(String[] args) {
      int [] test = {10, 3, 25, 1, 90, 4, 23, 30, 12, 0, 2, 54}; 
      printarray(mergesort(test));
  }
}
