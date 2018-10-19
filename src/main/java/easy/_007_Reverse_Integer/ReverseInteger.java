package easy._007_Reverse_Integer;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

/**
 * 题目 : 反转整数
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class ReverseInteger {
    public int reverse(int x) {
        return 0;
    }

    public int myReverse(int x) {
        long result = 0;
        int temp = x;
        while (temp != 0) {
            result = result * 10 + temp % 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
            temp /= 10;
        }
        return (int) result;
    }

    public int solutionReverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int faststReverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10;
            result += (x % 10);
            x = x / 10;
            if (result <= Integer.MIN_VALUE || result >= Integer.MAX_VALUE)
                return 0;
        }
        return (int) result;
    }
}