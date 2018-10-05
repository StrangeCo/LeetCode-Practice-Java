package medium._003_Longest_Substring_Without_Repeating_Characters;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTest {
    private String s1 = "abcabcbb";
    private String s2 = "bbbbb";
    private String s3 = "pwwkew";
    @Test
    public void lengthOfLongestSubstring() {
    }

    @Test
    public void myLengthOfLongestSubstring() {
        assertEquals(3,new LongestSubstringWithoutRepeatingCharacters().myLengthOfLongestSubstring(s1));
        assertEquals(1,new LongestSubstringWithoutRepeatingCharacters().myLengthOfLongestSubstring(s2));
        assertEquals(3,new LongestSubstringWithoutRepeatingCharacters().myLengthOfLongestSubstring(s3));
    }

    @Test
    public void solutionLengthOfLongestSubstring() {
    }

    @Test
    public void faststLengthOfLongestSubstring() {
    }
}