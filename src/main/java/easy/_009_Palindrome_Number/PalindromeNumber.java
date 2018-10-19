package easy._009_Palindrome_Number;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        return false;
    }

    public boolean isPalindromeMySolution(int x) {
        if (x < 0) return false;
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str);
        String reStr = sb.reverse().toString();
        for (int i = 0; i < reStr.length(); i++) {
            if (str.charAt(i) != reStr.charAt(i)) return false;
        }
        return true;
    }

    public boolean isPalindromeFastst(int x) {
        if (x < 0) {
            return false;
        }
        int origin = x;
        int reversed = 0;

        while (x != 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return reversed == origin;
    }
}
