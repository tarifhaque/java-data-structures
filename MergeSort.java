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
    if (array.length <= 1) return array;
    int mid = (int) Math.ceil(array.length / 2.0);

    int[] left = Arrays.copyOfRange(array, 0, mid);
    int[] right = Arrays.copyOfRange(array, mid + 1, array.length - 1);

    int[] sortedleft = mergesort(left);
    int[] sortedright = mergesort(right);

    return merge(sortedleft, sortedright) ;
  }
    
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
      int[] a = {0,1,3,7,9,10,10,12,13};
      int[] b = {1,2,4,6,6,6,7,8};
      int[] merged = merge(a, b);
      printarray(merged);
  }
}
