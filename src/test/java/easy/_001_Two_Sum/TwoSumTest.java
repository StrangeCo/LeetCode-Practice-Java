package easy._001_Two_Sum;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 由于一次就写出了答案 并没有针对性采集leetCode的测试用例
 * 欢迎大家PR补充测试用例
 * 这样项目就可以接近成为一个离线版的LeetCode了
 * PS : 运算的超时时间不好采集,大家还是尽可能的选择时间复杂度低的答案提交，保证自己的通过率哈
 */
public class TwoSumTest {
    private int[] nums1 = new int[]{2,7,11,15};
    private int target1 = 9;
    private int[] result1 = {0,1};
    @Test
    public void twoSum() {
    }

    @Test
    public void myTwoSum() {
        assertArrayEquals(result1,new TwoSum().myTwoSum(nums1,target1));
    }

    @Test
    public void fastTwoSum() {

    }

}