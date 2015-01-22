import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Testing Fibonacci
        int n = 5;
        System.out.printf("(Recursive) The %dth Fibonacci number is %d \n", n, Fibonacci.recursiveFib(n));
        System.out.printf("(Tabulated) The %dth Fibonacci number is %d \n", n, Fibonacci.tabulatedFib(n));
        System.out.printf("(Memoized) The %dth Fibonacci number is %d \n", n, Fibonacci.memoizedFib(n));

        // Testing Min Coin Sum
        int[] values = {1, 3, 5};
        System.out.println(Arrays.toString(MinCoinSum.minCoins(values, 11)));

    }
}
