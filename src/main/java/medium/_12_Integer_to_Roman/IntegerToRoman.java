package medium._12_Integer_to_Roman;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: "III"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "IV"
 * Example 3:
 * <p>
 * Input: 9
 * Output: "IX"
 * Example 4:
 * <p>
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 * <p>
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

/**
 * 题目 : 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        return "";
    }

    String[] str0 = new String[]{"I", "V", "X"};
    String[] str1 = new String[]{"X", "L", "C"};
    String[] str2 = new String[]{"C", "D", "M"};
    String[] str3 = new String[]{"M"};
    String[] index = new String[]{};

    // I, V, X, L, C,  D,  M
    // 1  5  10 50 100 500 1000
    public String myIntToRoman(int num) {
        int tempNum = num;
        StringBuffer sb = new StringBuffer();
        int indexNum = 1000;
        while (tempNum > 0) {
            switch (indexNum) {
                case 1000:
                    index = str3;
                    break;
                case 100:
                    index = str2;
                    break;
                case 10:
                    index = str1;
                    break;
                case 1:
                    index = str0;
                    break;
            }
            getOne(tempNum / indexNum, sb);
            tempNum = tempNum % indexNum;
            indexNum /= 10;
        }
        return sb.toString();
    }

    private StringBuffer getOne(int result, StringBuffer stringBuffer) {
        switch (result) {
            case 1:
                stringBuffer.append(index[0]);
                break;
            case 2:
                stringBuffer.append(index[0]).append(index[0]);
                break;
            case 3:
                stringBuffer.append(index[0]).append(index[0]).append(index[0]);
                break;
            case 4:
                stringBuffer.append(index[0]).append(index[1]);
                break;
            case 5:
                stringBuffer.append(index[1]);
                break;
            case 6:
                stringBuffer.append(index[1]).append(index[0]);
                break;
            case 7:
                stringBuffer.append(index[1]).append(index[0]).append(index[0]);
                break;
            case 8:
                stringBuffer.append(index[1]).append(index[0]).append(index[0]).append(index[0]);
                break;
            case 9:
                stringBuffer.append(index[0]).append(index[2]);
                break;
            case 0:
                break;
        }
        return stringBuffer;
    }

    /**
     * 看到一个有意思的答案
     * 把所有可能性都遍历了出来
     * 最后直接拼起来
     */
    public String otherIntToRoman(int num) {
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String M[] = {"", "M", "MM", "MMM"};
        return M[num / 1000] + C[num % 1000 / 100] + X[num % 100 / 10] + I[num % 10];
    }

    /**
     * 国内最快
     */
    public String faststIntToRoman(int num) {
        String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int index = 0;
        StringBuffer sb = new StringBuffer();
        while (num > 0) {
            if (num >= values[index]) {
                sb.append(letters[index]);
                num -= values[index];
            } else {
                index++;
            }
        }
        return sb.toString();
    }
}
