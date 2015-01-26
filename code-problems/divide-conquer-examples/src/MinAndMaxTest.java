import org.junit.Test;

import static org.junit.Assert.*;

public class MinAndMaxTest {

    @Test
    public void testMinmaxtuple() throws Exception {
        int[] test = {8, 5, 12, 7, 3, 9, 6};
        int[] result = {3, 5, 9, 12};
        assertArrayEquals(MinAndMax.minmaxtuple(test, 0, test.length - 1), result);

    }
}