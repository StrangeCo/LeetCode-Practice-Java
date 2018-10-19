package medium._006_ZigZag_Conversion;

import org.junit.Test;

import static org.junit.Assert.*;

public class ZigZagConversionTest {
    private String input = "PAYPALISHIRING";
    private String output = "PAHNAPLSIIGYIR";
    private int newRows = 3;
    @Test
    public void convert() {

    }

    @Test
    public void myConvert() {
        assertEquals(new ZigZagConversion().myConvert(input,newRows),output);
    }

    @Test
    public void solutionConvert() {
        assertEquals(new ZigZagConversion().solutionConvert1(input,newRows),output);
        assertEquals(new ZigZagConversion().solutionConvert2(input,newRows),output);
    }
}