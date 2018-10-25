package medium._017_Letter_Combinations_Of_A_Phone_Number;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 题目 ; 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        return null;
    }

    private ArrayList<StringBuilder> genareteArrays(List<StringBuilder> lists, String[] strs) {
        ArrayList<StringBuilder> newStringBuilder = new ArrayList<>();
        for (StringBuilder sb : lists) {
            for (String str : strs) {
                newStringBuilder.add(new StringBuilder(sb).append(str));
            }
        }
        return newStringBuilder;
    }

    /**
     * 递归...好像没什么可说的
     */
    public List<String> myLetterCombinations(String digits) {
        if (digits.equals("")) return new ArrayList<>();
        String[] num_2 = {"a", "b", "c"};
        String[] num_3 = {"d", "e", "f"};
        String[] num_4 = {"g", "h", "i"};
        String[] num_5 = {"j", "k", "l"};
        String[] num_6 = {"m", "n", "o"};
        String[] num_7 = {"p", "q", "r", "s"};
        String[] num_8 = {"t", "u", "v"};
        String[] num_9 = {"w", "x", "y", "z"};
        ArrayList<StringBuilder> list = new ArrayList<>();
        list.add(new StringBuilder());
        for (int j = 0; j < digits.length(); j++) {
            switch (digits.charAt(j)) {
                case '2':
                    list = genareteArrays(list, num_2);
                    break;
                case '3':
                    list = genareteArrays(list, num_3);
                    break;
                case '4':
                    list = genareteArrays(list, num_4);
                    break;
                case '5':
                    list = genareteArrays(list, num_5);
                    break;
                case '6':
                    list = genareteArrays(list, num_6);
                    break;
                case '7':
                    list = genareteArrays(list, num_7);
                    break;
                case '8':
                    list = genareteArrays(list, num_8);
                    break;
                case '9':
                    list = genareteArrays(list, num_9);
                    break;
                default:
                    return new ArrayList<>();
            }
        }
        ArrayList<String> strings = new ArrayList<>();
        for (StringBuilder sb : list) {
            strings.add(sb.toString());
        }
        return strings;
    }

    /**
     * 国外官方最快
     */
    public List<String> faststLetterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] key = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(res, "", 0, digits, key);
        return res;

    }

    public void helper(List<String> res, String curr, int currIdx, String digits, String[] key) {
        if (currIdx > digits.length() - 1) {
            res.add(curr);
            return;
        }
        String digit = key[(digits.charAt(currIdx) - '0')];
        for (int i = 0; i < digit.length(); i++) {
            helper(res, curr + digit.charAt(i), currIdx + 1, digits, key);
        }
    }
}
