package easy._009_Palindrome_Number;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeNumberTest {
    private int input = -121;
    private boolean output = false;
    private int input1 = -121;
    private boolean output1 = false;
    private int input2 = 10;
    private boolean output2 = false;
    private int input3 = 121;
    private boolean output3 = true;
    @Test
    public void isPalindrome() {
    }

    @Test
    public void isPalindromeMySolution() {
        assertEquals(new PalindromeNumber().isPalindromeFastst(input),output);
        assertEquals(new PalindromeNumber().isPalindromeFastst(input1),output1);
        assertEquals(new PalindromeNumber().isPalindromeFastst(input2),output2);
        assertEquals(new PalindromeNumber().isPalindromeFastst(input3),output3);
    }

    @Test
    public void isPalindromeFastst() {
    }
}