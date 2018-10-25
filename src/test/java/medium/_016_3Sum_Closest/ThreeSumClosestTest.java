package medium._016_3Sum_Closest;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeSumClosestTest {
    private int[] input = new int[]{-1, 2, 1, -4};
    private int tartgetinput = 1;
    private int output = 2;

    @Test
    public void threeSumClosest() {
    }

    @Test
    public void myThreeSumClosest() {
        assertEquals(new ThreeSumClosest().myThreeSumClosest(input, tartgetinput), output);
    }

    @Test
    public void faststThreeSumClosest() {
    }
}