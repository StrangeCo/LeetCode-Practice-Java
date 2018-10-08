package medium._006_ZigZag_Conversion;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */

/**
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 * 实现一个将字符串进行指定行数变换的函数:
 * string convert(string s, int numRows);
 * <p>
 * 示例 1:
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 * 示例 2:
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        return "";
    }

    /**
     * numRows = 3
     *
     * @param s
     * @param numRows
     * @return
     */
    public String myConvert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        int length = s.length();
        int index = 0;
        while (count < length) {
            if (index < length) {
                stringBuilder.append(s.charAt(index));
                int index2 = index + numRows * 2 - 2;
                if (index2 < length) {
                    stringBuilder.append(index2);
                } else {
                    index++;
                }
            }
        }
        return stringBuilder.toString();
    }

    public String solutionConvert(String s, int numRows) {
        return "";
    }

    public String faststConvert(String s, int numRows) {
        return "";
    }
}
