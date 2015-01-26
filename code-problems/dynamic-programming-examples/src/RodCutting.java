/*******************************************************
 * See: Rod-cutting problem (p. 360)
 * Introduction to Algorithms, Third Edition (Cormen)
 *
 * Given a rod of length n, and an array of prices,
 * lengthPrices[i], where i = 1, 2, .., n determine
 * the maximum revenue obtainable by cutting up the rod
 * and selling the pieces.
 *
 * A recursive and dynamic programming solution is
 * impemented.
 *
 * Last Revised: 25 Jan 2015
 * Tarif Haque
 *******************************************************/

public class RodCutting {

    /**************************************
     * It is sad how inefficient this is...
     **************************************/
    public static int recursivelyCutRod(int[] lengthPrices, int rodLength) {

        if (rodLength == 0) return 0;

        int[] solutions = new int[(rodLength / 2) + 1];
        solutions[0] = lengthPrices[rodLength];

        for (int i = 1; i < solutions.length; i++) {
            solutions[i] = recursivelyCutRod(lengthPrices, i) + recursivelyCutRod(lengthPrices, rodLength - i);
        }

        return max(solutions);
    }

    private static int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }

}
