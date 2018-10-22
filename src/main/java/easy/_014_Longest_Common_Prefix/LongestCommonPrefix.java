package easy._014_Longest_Common_Prefix;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */

/**
 * 题目 : 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        return "";
    }

    /**
     * 我的思路是 既然是公共前缀 那么最长就是最短的字符串
     * 先遍历求出最短的字符串长度
     * 然后从0遍历最短字符串的长度
     * 然后挨个对比每个字符串的每一位char是否相同
     * 不同就返回这个串
     */
    public String myLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
        }
        StringBuilder sb = new StringBuilder();
        char temp;
        for (int i = 0; i < min; i++) {
            temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (temp != strs[j].charAt(i)) return sb.toString();
            }
            sb.append(String.valueOf(temp));
        }
        return sb.toString();
    }

    /**
     * 官方答案很多 就不都摘抄了
     * 官方答案
     * 1.横向搜索
     * 2.纵向搜索
     * 3.分治
     * 4.二分查找
     */
    public String solutionLongestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public String faststLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String minWord = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minWord.length()) {
                minWord = strs[i];
            }
        }
        while (minWord.length() > 0) {
            boolean isTrue = true;
            for (String str : strs) {
                if (!str.startsWith(minWord)) {
                    isTrue = false;
                    break;
                }
            }
            if (!isTrue) {
                minWord = minWord.substring(0, minWord.length() - 1);
            } else {
                break;
            }
        }
        return minWord;
    }
}
