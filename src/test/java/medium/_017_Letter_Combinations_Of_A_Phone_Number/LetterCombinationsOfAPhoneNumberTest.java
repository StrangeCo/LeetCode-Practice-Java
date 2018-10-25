package medium._017_Letter_Combinations_Of_A_Phone_Number;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LetterCombinationsOfAPhoneNumberTest {
    private String input = "23";
    private List<String> output = new ArrayList<>();

    @Test
    public void letterCombinations() {
    }

    @Test
    public void myLetterCombinations() {
        output = new ArrayList<String>(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
        assertEquals(new LetterCombinationsOfAPhoneNumber().myLetterCombinations(input), output);
    }

    @Test
    public void faststLetterCombinations() {
    }
}