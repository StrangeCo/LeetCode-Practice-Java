package medium._008_String_Reverse_Integer;

/**
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * If the numerical value is out of the range of representable values, INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−2^31) is returned.
 */

/**
 * 题目 : 字符串转整数
 * 实现 atoi，将字符串转为整数。
 * <p>
 * 该函数首先根据需要丢弃任意多的空格字符，直到找到第一个非空格字符为止。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * <p>
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 * <p>
 * 若函数不能执行有效的转换，返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−2^31) 。
 */
public class StringReverseInteger {
    public int myAtoi(String str) {
        return 0;
    }

    /**
     * 这个题没有官方正确答案
     */
    public int myMyAtoi(String str) {
        if (str == null || str.trim().length() == 0) return 0;
        str = str.trim();
        int start = 0;
        long sum = 0;
        int flag = 1;
        char firstChar = str.charAt(0);
        String firstStr = Character.toString(firstChar);
        if (firstStr.equals("+")) {
            flag = 1;
            start++;
        } else if (firstStr.equals("-")) {
            flag = -1;
            start++;
        }
        int length = str.length();
        for (int i = start; i < length; i++) {
            if (!Character.isDigit(str.charAt(i))) return (int) sum * flag;
            sum = sum * 10 + str.charAt(i) - '0';
            if (flag == 1 && sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (flag == -1 && (-1) * sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) sum * flag;
    }

    /**
     * 国外最快
     */
    public int faststMyAtoi1(String str) {
        if (str.length() == 0) return 0;
        int aS = 0;
        for (; aS < str.length() && str.charAt(aS) == ' '; aS++) ;
        if (aS >= str.length() || !isVal(str.charAt(aS))) return 0;
        byte sign = 1;
        if (iSign(str.charAt(aS))) {
            if (str.charAt(aS) == '-') sign = -1;
            aS++;
        }
        if (aS >= str.length()) return 0;
        long val = 0;
        for (; aS < str.length() && isNum(str.charAt(aS)); aS++) {
            val += 9 * val + (sign * (byte) (str.charAt(aS) - '0'));
            if (val > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (val < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) val;
    }

    public boolean isVal(char c) {
        return isNum(c) || iSign(c);
    }

    public boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public boolean iSign(char c) {
        return c == '+' || c == '-';
    }

    /**
     * 国内最快
     */
    public int faststmMAtoi2(String str) {
        int len = str.length();
        if (len == 0) {
            return 0;
        }
        char[] cs = str.toCharArray();
        int i = 0;
        while (i < len && cs[i++] == ' ') {

        }
        i--;
        char c1 = cs[i];
        int sig = 1;
        if ((c1 > '9' || c1 < '0')) {
            if (c1 == '-') {
                sig = -1;
                i++;
            } else if (c1 == '+') {
                i++;
            } else {
                return 0;
            }
        }
        long v = 0;
        for (; i < len; i++) {
            char c = cs[i];
            if (c < '0' || c > '9') {
                break;
            }
            v = v * 10 + (c - '0');
            if (v * sig > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (v * sig < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) (v * sig);
    }
}
