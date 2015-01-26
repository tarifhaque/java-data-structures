public class Main {

    public static void main(String[] args) {

        /*
        // Testing Fibonacci
        int n = 5;
        System.out.printf("(Recursive) The %dth Fibonacci number is %d \n", n, Fibonacci.recursiveFib(n));
        System.out.printf("(Tabulated) The %dth Fibonacci number is %d \n", n, Fibonacci.tabulatedFib(n));
        */

        /*
        // Testing Min Coin Sum
        int[] values = {1, 3, 5};
        System.out.println(Arrays.toString(MinCoinSum.minCoins(values, 11)));
        */

        // Testing Rod Cutting
        int[] lengthPrices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.print(RodCutting.recursivelyCutRod(lengthPrices, 10));
    }
}
