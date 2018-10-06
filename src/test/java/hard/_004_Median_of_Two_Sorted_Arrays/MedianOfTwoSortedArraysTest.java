package hard._004_Median_of_Two_Sorted_Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedianOfTwoSortedArraysTest {
    private int[] num1 = new int[]{1,3,4,5,6,7,8,9,10};
    private int[] num2 = new int[]{2};
    private double result = 5.5;
    @Test
    public void findMedianSortedArrays() {
    }

    @Test
    public void myFindMedianSortedArrays() {
        assertEquals(result,new MedianOfTwoSortedArrays().myFindMedianSortedArrays(num1,num2),0.0);
    }

    @Test
    public void solutionFindMedianSortedArrays() {
    }

    @Test
    public void faststFindMedianSortedArrays() {
    }
}