package easy._013_Roman_To_Integer;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanToIntegerTest {
    private int output = 3;
    private String input = "III";
    private int output1 = 4;
    private String input1 = "IV";
    private int output2 = 9;
    private String input2 = "IX";
    private int output3 = 58;
    private String input3 = "LVIII";
    private int output4 = 1994;
    private String input4 = "MCMXCIV";

    @Test
    public void romanToInt() {
    }

    @Test
    public void myRomanToInt() {
        assertEquals(new RomanToInteger().myRomanToInt(input),output);
        assertEquals(new RomanToInteger().myRomanToInt(input1),output1);
        assertEquals(new RomanToInteger().myRomanToInt(input2),output2);
        assertEquals(new RomanToInteger().myRomanToInt(input3),output3);
        assertEquals(new RomanToInteger().myRomanToInt(input4),output4);
    }

    @Test
    public void solutionRomanToInt() {
    }

    @Test
    public void faststRomanToInt() {
    }
}