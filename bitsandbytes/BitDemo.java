public class BitDemo {

    /* Test whether the nth bit is set in an integer. Let n start at 0. */
    public static boolean isSet(int test, int n) {
        int x = (int) Math.pow(2, n);
        if (test - x >= 0) return true;
        else return false;
    }
  
    /* Print the decimal and binary representations of a number n. */
    public static void printInt(int n) {
        System.out.printf("(%d, %s)\n", n, Integer.toBinaryString(n));
    }

    public static void main(String[] args) {
        int a = 65; /* 0100 0001 */
        int b = 13; /* 0000 1101 */
        int c = a & b; /* Should be 12 */ 

        System.out.println("(Decimal, Binary)");
        printInt(a);
        printInt(b);
        printInt(c);

        System.out.println(isSet(a, 6));
    }
}
