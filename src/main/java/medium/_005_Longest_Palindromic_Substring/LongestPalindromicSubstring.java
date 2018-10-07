package medium._005_Longest_Palindromic_Substring;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */

/**
 * 题目: 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        return "";
    }

    /**
     * 这个方法是暴力破解
     * 时间复杂度O(n^3)
     * 所以leetcode并不能通过...
     */
    public String myLongestPalindrome(String s) {
        if (s.length() <= 1) return s;
        for (int i = s.length(); i > 0; i--) {//子串长度
            for (int j = 0; j <= s.length() - i; j++) {
                String sub = s.substring(j, i + j);//子串位置
                int count = 0;//计数，用来判断是否对称          
                for (int k = 0; k < sub.length() / 2; k++) {//左右对称判断
                    if (sub.charAt(k) == sub.charAt(sub.length() - k - 1))
                        count++;
                }
                if (count == sub.length() / 2)
                    return sub;
            }
        }
        return "";//表示字符串中无回文子串
    }

    /**
     * 从中心向外扩散
     * 时间复杂度O(N^2)
     */
    public String solutionLongestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * 还有一种Manacher's Algorithm 马拉车算法
     * 时间复杂度O(N)
     * https://www.cnblogs.com/grandyang/p/4475985.html
     * 答案从这里看哈
     */
    public String Manacher(String s) {
        return "";
    }

    /**
     * 6ms
     */
    int max = 0;
    int left = 0;
    char[] cs;

    public String faststLongestPalindrome(String s) {
        if (s.length() == 0 || s == null)
            return "";
        cs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            i = helper(i);
        }
        return s.substring(left, left + max);
    }

    private int helper(int index) {
        int ll = index, rr = index;
        while (rr < cs.length - 1 && cs[rr] == cs[rr + 1]) {
            rr++;
        }
        int temp = rr;
        while (ll > 0 && rr < cs.length - 1 && cs[ll - 1] == cs[rr + 1]) {
            ll--;
            rr++;
        }

        if (rr - ll + 1 > max) {
            max = rr - ll + 1;
            left = ll;
        }
        return temp;
    }
}
