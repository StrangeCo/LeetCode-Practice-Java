package easy._007_Reverse_Integer;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseIntegerTest {
    private int input1= 123;
    private int output1= 321;

    private int input2= -123;
    private int output2= -321;

    private int input3 = 120;
    private int output3 = 21;
    @Test
    public void reverse() {
    }

    @Test
    public void myReverse() {
        assertEquals(new ReverseInteger().myReverse(input1),output1);
        assertEquals(new ReverseInteger().myReverse(input2),output2);
        assertEquals(new ReverseInteger().myReverse(input3),output3);
    }

    @Test
    public void solutionReverse() {
    }
}