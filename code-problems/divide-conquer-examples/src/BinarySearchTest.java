import static org.junit.Assert.*;

public class BinarySearchTest {

    // test array of even length
    int[] testeven = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    // test array of odd length
    int[] testodd = {0, 1, 2, 3, 4};

    @org.junit.Test
    public void testBinarysearch() throws Exception {
        for (int i = 0; i < testeven.length; i++) {
            assertEquals(BinarySearch.binarysearch(i, testeven), i);
        }

        for (int i = 0; i < testodd.length; i++) {
            assertEquals(BinarySearch.binarysearch(i, testodd), i);
        }
    }


}