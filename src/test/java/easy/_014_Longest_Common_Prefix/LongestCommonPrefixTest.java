package easy._014_Longest_Common_Prefix;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {
    private String[] input = new String[]{"flower", "flow", "flight"};
    private String output = "fl";

    @Test
    public void longestCommonPrefix() {
    }

    @Test
    public void myLongestCommonPrefix() {
        assertEquals(new LongestCommonPrefix().myLongestCommonPrefix(input),output);
    }

    @Test
    public void solutionLongestCommonPrefix() {
    }

    @Test
    public void faststLongestCommonPrefix() {
    }
}