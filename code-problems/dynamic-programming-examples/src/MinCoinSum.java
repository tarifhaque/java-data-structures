/*
Dynamic programming example

Given a list of N coins, their values (V1, V2, ... , VN), and the total sum S,
find the minimum number of coins the sum of which is S (use as many coins of one type as we want),
or report that it's not possible to select coins in such a way that they sum up to S.

See: http://www.topcoder.com/tc?d1=tutorials&d2=dynProg&module=Static
 */


public class MinCoinSum {

    public static int[] minCoins(int[] coinvalues, int sum) {
        int[] min = new int[sum + 1];
        min[0] = 0;

        for (int i = 1; i < min.length; i++) {
            min[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < min.length; i++) {
            for (int j = 0; j < coinvalues.length; j++) {
                if (coinvalues[j] <= i && min[i - coinvalues[j]] + 1 < min[i])
                    min[i] = min[i - coinvalues[j]] + 1;
            }
        }

        return min;
    }

}
