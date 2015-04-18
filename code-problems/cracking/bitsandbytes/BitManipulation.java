/* * * * * * * * * * * * * * * *
 * BitManipulation.java
 *
 * A class with a bunch of static methods for bit maniputlation.
 * * * * * * * * * * * * */

public class BitManipulation {

    /* Count the number of set bits in a given number */
    public static int countSetBits(int num) {
        int setBits = 0; // counter
        int bitmask = 0b1; // successively AND the bitmask with the number

        for (int i = 1; i < 31; i++) {
            if ((num & bitmask) == bitmask) setBits++;
            bitmask = bitmask << 1;
        }

        return setBits;
    }

    /* Get the ith bit in the number, where i = 0 at the LSB */
    public static boolean getBit(int num, int i) {
        int bitmask = 1 << i;
        if ((num & bitmask) == 0) return false;
        else return true;
    }

    /* Set the ith bit in the number */
    public static int setBit(int num, int i) {
        int bitmask = 1 << i;
        return (num | bitmask);
    }

    /* Clear the ith bit in the number */
    public static int clearBit(int num, int i) {
        int bitmask = ~(1 << i);
        return (num & bitmask);
    }

    public static void main(String[] args) {
        int x = 0b1000;

        /* Test getBit() 
        for (int i = 0; i < 8; i++) 
            System.out.print(getBit(x, i) + " ");
        System.out.println();
        */

        System.out.println(clearBit(x, 3));
    }

}
