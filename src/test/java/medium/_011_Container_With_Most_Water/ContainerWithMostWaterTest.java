package medium._011_Container_With_Most_Water;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {
    private int[] input = new int[]{1,8,6,2,5,4,8,3,7};
    private int output = 49;
    @Test
    public void maxArea() {
    }

    @Test
    public void myMaxArea() {
        assertEquals(new ContainerWithMostWater().myMaxArea(input),output);
    }

    @Test
    public void solutionMaxArea() {
    }

    @Test
    public void faststMaxArea() {
    }
}