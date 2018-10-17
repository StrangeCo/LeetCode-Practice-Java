package medium._008_String_Reverse_Integer;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringReverseIntegerTest {
    String input = "42";
    int output = 42;

    String input1 = "-42";
    int output1 = -42;

    String input2 = "    -42";
    int output2 = -42;

    String input3 = "4193 with words";
    int output3 = 4193;

    String input4 = "words and 987";
    int output4 = 0;

    String input5 = "-91283472332";
    int output5 = -2147483648;

    @Test
    public void myAtoi() {
    }

    @Test
    public void myMyAtoi() {
//        assertEquals(new StringReverseInteger().myMyAtoi(input),output);
//        assertEquals(new StringReverseInteger().myMyAtoi(input1),output1);
//        assertEquals(new StringReverseInteger().myMyAtoi(input2),output2);
//        assertEquals(new StringReverseInteger().myMyAtoi(input3),output3);
//        assertEquals(new StringReverseInteger().myMyAtoi(input4),output4);
        assertEquals(new StringReverseInteger().myMyAtoi(input5),output5);
    }
}