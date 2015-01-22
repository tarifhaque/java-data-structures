import org.junit.Test;

import static org.junit.Assert.*;

public class PowerTest {

    @Test
    public void testComputePower() throws Exception {
        // 2 ^ 2 = 4
        assertEquals(Power.computePower(2, 2), 4);

        // 2 ^ 5 = 32
        assertEquals(Power.computePower(2, 5), 32);

        // 5 ^ 3 = 125
        assertEquals(Power.computePower(5, 3), 125);

        // 3 ^ 4 = 81
        assertEquals(Power.computePower(3, 4), 81);

        // 10 ^ 0 = 1
        assertEquals(Power.computePower(10, 0), 1);
    }
}