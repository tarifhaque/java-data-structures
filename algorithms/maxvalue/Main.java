import java.util.Random;
import java.util.Arrays;

public class Main {
        
    /* Return a random integer from min to max inclusive. */
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /* Return an array of random integers of size n. */
    public static int[] randomarray(int n, int min, int max) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = randInt(min, max); 
        }
        return array;
    }

    public static int maxTwo(int a, int b) {
        if (a > b) return a;
        else return b;
    }

    public static int maxvalue(int[] array, int low, int high) {

        if (high == low + 1) { // two elements
            return maxTwo(array[low], array[high]);
        } else if (low == high) { // one element
            return array[low];
        } else {
            int mid = low + ((high - low) / 2); 
            int leftmax = maxvalue(array, low, mid);
            int rightmax = maxvalue(array, mid + 1, high);
            return maxTwo(leftmax, rightmax);
        }
       
    }

    public static void main(String[] args) {
        int[] array = randomarray(20, 0, 100);
        int max = maxvalue(array, 0, array.length - 1);
        
        System.out.println(Arrays.toString(array));
        System.out.println(max);
    }
}
