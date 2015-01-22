public class Power {

    /**
     * Computes x ^ n using a divide and conquer approach.
     *
     * Time complexity
     * T(n) = T(n/2) + O(n)
     *
     * @param x base
     * @param n exponent
     */
    public static int computePower(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        else if (n % 2 == 0) {
            int thing = computePower(x, n / 2);
            return thing * thing;
        }
        else {
            int thing = computePower(x, (n - 1) / 2);
            return x * thing * thing;
        }
    }


}
