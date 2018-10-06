package medium._003_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */


/**
 * 题目 :无重复字符的最长子串
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
 * 请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        return 0;
    }

    /**
     * 用一个set集合放长串来和后面的元素用contains对比是否有重复元素
     * i代表起始位置 j代表要去对比的下一个元素
     * 如果有重复的就把那个元素移除出set集合然后起始位置加1 直到清除到和j元素一样的元素停止
     * 然后开始继续判断 只要比原来的长度长就重新赋值 直到遍历完为止
     */
    public int myLengthOfLongestSubstring(String s) {
        int length = s.length();
        int count = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < length && j < length) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                count = Math.max(count, j - i);
            }
        }
        return count;
    }

    /**
     * 我们可以定义字符到其索引的映射，而不是使用集合来判断字符是否存在。 然后，当我们找到重复的字符时，我们可以立即跳过字符。
     * 原因是如果s [j] s [j]在[i，j] [i，j]范围内具有索引j＆＃x27;
     * j的副本我们不需要一点一点地增加ii。
     * 我们可以跳过范围[i，j] [i，j]让我成为j+ 1j直接+1。
     * 时间复杂度是O(2n)
     */
    public int solutionLengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * Java（假设ASCII 128）
     * 以前的实现都没有对字符串s的字符集进行假设。
     * 如果我们知道charset相当小，我们可以用整数数组替换Map作为直接访问表。
     * 常用的表有：
     * int [26] for Letters'a' - 'z'或'A' - 'Z'
     * ASCII [128]用于ASCII
     * int [256]用于扩展ASCII
     */
    public int faststLengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int i = 0, j = 0; j < n; j++) {
            int new_char = s.charAt(j);
            i = Math.max(index[new_char], i);
            ans = Math.max(ans, j - i + 1);
            index[new_char] = j + 1;
        }
        return ans;
    }
}
