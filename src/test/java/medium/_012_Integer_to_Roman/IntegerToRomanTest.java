package medium._012_Integer_to_Roman;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerToRomanTest {
    private int input = 3;
    private String output = "III";
    private int input1 = 4;
    private String output1 = "IV";
    private int input2 = 9;
    private String output2 = "IX";
    private int input3 = 58;
    private String output3 = "LVIII";
    private int input4 = 1994;
    private String output4 = "MCMXCIV";

    @Test
    public void intToRoman() {
    }

    @Test
    public void myIntToRoman() {
        assertEquals(new IntegerToRoman().myIntToRoman(input),output);
        assertEquals(new IntegerToRoman().myIntToRoman(input1),output1);
        assertEquals(new IntegerToRoman().myIntToRoman(input2),output2);
        assertEquals(new IntegerToRoman().myIntToRoman(input3),output3);
        assertEquals(new IntegerToRoman().myIntToRoman(input4),output4);
    }

    @Test
    public void solutionIntToRoman() {
    }

    @Test
    public void faststIntToRoman() {
    }
}