/**********************************************
 * Dynamic programming - start with this!
 * Computing the fibonacci numbers.
 *
 * Recurrence
 * f(0) = 0, f(1) = 1
 * f(n) = f(n - 2) + f(n - 1)
 ***********************************************/

public class Fibonacci {

    /*****************************************
     * The inefficient recursive strategy.
     *****************************************/
    public static int recursiveFib(int n) {
        if (n <= 1) return n;
        else return recursiveFib(n - 2) + recursiveFib(n - 1);
    }

    /*****************************************
     * Compute the Fibonacci numbers bottom-up
     * using dynamic programming.
     *****************************************/
    public static int tabulatedFib(int n) {
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i < table.length; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        return table[n];
    }

}
