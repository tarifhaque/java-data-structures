/* * *
 * A trickier problem than it seems..  
 *
 * Write a function that finds the median of a set of three numbers.
 * Also find the Big O. Can it be done with only 2 comparisons, or do you need 3?  
 */

import java.util.*;

public class MedianThree {

    /* *
     * In the worst case, we need to make three comparisons.
     * In the best case, we need to make two comparisons.
     **/
    private static int medianthree(int a, int b, int c) {
        int mid;

        if (a < b) {
            if (a > c) mid = a;
            else { // b & c are >= a, so pick smaller among two 
                if (b < c) mid = b;
                else mid = c;
            }
        } else {
            if (a < c) mid = a; 
            else { // b & c are <=  a, so pick larger among two
                if (b > c) mid = b;
                else mid = c;
            }
        }

        return mid;
    }

    private static void printTest(int a, int b, int c) {
        String string = "("; 
        string += String.valueOf(a) + " " + String.valueOf(b) + " ";
        string += String.valueOf(c) + ")";
        System.out.println(string);

        int median = medianthree(a, b, c);
        System.out.println("Median: " + String.valueOf(median));
    }

    public static void main(String[] args) {
        printTest(1, 2, 3);
        printTest(2, 3, 4);
        printTest(3, 2, 1);
        printTest(100, 200, 50);
        printTest(1, 1, 1);
        printTest(0, 2, 0);
        printTest(5, 4, 3);
        printTest(1, 3, 2);
        printTest(4, 2, 1);
    }
}
