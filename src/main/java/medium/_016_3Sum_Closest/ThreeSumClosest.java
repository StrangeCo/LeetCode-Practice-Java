package medium._016_3Sum_Closest;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

import java.util.Arrays;

/**
 * 最接近的三个数
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        return 0;
    }

    /**
     * 和上一道题很相似
     * 无非是用Math.abs求绝对值
     */
    public int myThreeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int res = target - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int total = nums[start] + nums[end] + nums[i];
                if (result == Integer.MAX_VALUE || Math.abs(result - target) > Math.abs(total - target)) {
                    result = total;
                }
                if (nums[start] + nums[end] == res) return target;
                else if (nums[start] + nums[end] < res) start++;
                else end--;
            }
        }
        return result;
    }

    /**
     * 国内最快
     */
    public int faststThreeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;

            while (start < end) {
                int tmpSum = nums[i] + nums[start] + nums[end];
                if (Math.abs(tmpSum - target) < Math.abs(result - target))
                    result = tmpSum;
                if (tmpSum < target)
                    start++;
                else if (tmpSum > target)
                    end--;
                else
                    return result;

            }
        }
        return result;
    }
}
