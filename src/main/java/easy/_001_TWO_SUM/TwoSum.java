package easy._001_TWO_SUM;

import java.util.HashMap;
import java.util.Map;

/**
 * 英文
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * 中文
 * 题目: 两数相加
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    private int[] nums = new int[]{2, 7, 11, 15};
    private int target = 9;
    private int[] result = {0, 1};

    public int[] twoSum(int[] nums, int target) {
        // TODO: 2018/9/27 0027 your answer
        return null;
    }

    /**
     * 开始思考的就是先解决问题
     * 就这种暴力破解的方法是我第一想到的答案
     * 时间复杂度是O(n^2)
     * 空间复杂度是O（1）
     */
    public int[] myTwoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        int length = nums.length;
        int temp;
        for (int i = 0; i < length; i++) {
            temp = target - nums[i];
            for (int j = i + 1; j < length; j++) {
                if (temp == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 一次通过哈希表
     * 时间复杂度是O(n)
     * 空间复杂度是O(n)
     */
    public int[] OnePassHashTableTwoSum(int[] nums, int target) {
        Map<Integer, Integer> valueLocations = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer complement = valueLocations.get(target - nums[i]);
            if (complement != null) {
                return new int[]{complement, i};
            }
            valueLocations.put(nums[i], i);
        }
        return null;
    }

    /**
     * 还有2次通过哈希表的解法
     * 时间复杂度是O(n)
     * 空间复杂度是O(n)
     */
    public int[] TwoPassHashTableTwoSum(int[] nums, int target) {
        // TODO: 2018/9/28 0028 可以练习一下呦
        return null;
    }

    /**
     * 2018.9.28.最快答案
     * 个人感觉是针对leetcode做了优化 所以延迟很低
     * 以上三种方法会了就差不多了
     * 这种方法了解了解思路就好
     */
    public int[] fastestTwoSum(int[] nums, int target) {
        final int il = nums.length;
        int pot = 4096;
        final int bitMod = pot - 1;
        final int[] bucket = new int[pot];
        final int[] linked = new int[il];
        final int firstVal = nums[0];
        for (int i = 1; i < il; i++) {
            int currNum = nums[i];
            int complement = target - currNum;
            if (complement == firstVal) {
                return new int[]{0, i};
            }
            int complementLLIndex = bucket[complement & bitMod];
            while (complementLLIndex != 0) {
                if (nums[complementLLIndex] == complement) {
                    return new int[]{complementLLIndex, i};
                }
                complementLLIndex = linked[complementLLIndex];
            }
            int currNumLLIndex = currNum & bitMod;
            linked[i] = bucket[currNumLLIndex];
            bucket[currNumLLIndex] = i;
        }
        return null;
    }
}