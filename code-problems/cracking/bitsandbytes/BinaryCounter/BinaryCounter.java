/* * * * * * * * * * * * * * * * * * * * * * * * * * 
 * A n-bit binary counter that counts upward from 0.
 *
 * Tarif Haque
 * * * */

public class BinaryCounter {

    int numBits;

    // least significant bit at bits[numBits - 1]
    boolean[] bits;

    public BinaryCounter(int n) {
        this.numBits = n;  
        this.bits = new boolean[n];
    }

    public BinaryCounter(boolean[] initialBits) {
        this.bits = initialBits;
        numBits = initialBits.length;
    }

    private String boolToString(boolean value) {
        if (value) return "1";
        else return "0";
    }

    public String string() {
        String result = "";
        for (int i = 0; i < numBits; i++) {
            result = result + boolToString(bits[i]);
        }
        return result;
    }

    public void printCounter() {
        System.out.printf("count: %s\n", this.string());
    }

    /* * * * * * * * * * * * * * * * * * * * *  
     * Increment the counter one. Overflow if 
     * counter is at max value (e.g. if we
     * increment a 4-bit counter with a value
     * of 1111 we would get 0000).
     * * * * * * * * * * * * * * * * * * * * */
    public void increment() {
        // start from least significant bit
        int counter = numBits - 1;

        while (bits[counter]) {
            bits[counter] = false;
            counter--;
            if (counter == -1) break;
        }
       
        if (counter != -1) // if we did not overflow 
            bits[counter] = true;
    }

    /* Increment the counter n times */
    public void increment(int n) {
        for (int i = 0; i < n; i++) {
            increment();
        }
    }
}
