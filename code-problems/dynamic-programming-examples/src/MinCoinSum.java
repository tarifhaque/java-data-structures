/*
Dynamic programming example

Given a list of N coins, their values (V1, V2, ... , VN), and the total sum S,
find the minimum number of coins the sum of which is S (use as many coins of one type as we want),
or report that it's not possible to select coins in such a way that they sum up to S.

See: http://www.topcoder.com/tc?d1=tutorials&d2=dynProg&module=Static
 */

public class MinCoinSum {

    public static void main(String[] args) {

        int[] coinvalues = {1, 3, 5};
        int sum = 11;
        int[] min = new int[sum + 1];

        min[0] = 0;

        /*
        sum 0 - 0 coins
        sum 1 - 1 coin
        sum 2 - sum 1 + 1 coin = 2 coins
        sum 3 - sum 2 + 1 coin = 3 coins
        sum 4 - sum 3 + 1 coin = 4 coins
        sum 5 - sum 4
         */

        for (int i = 1; i < min.length; i++) {
            for (int j = 0; j < coinvalues.length; j++) {

            }
        }

    }


}
