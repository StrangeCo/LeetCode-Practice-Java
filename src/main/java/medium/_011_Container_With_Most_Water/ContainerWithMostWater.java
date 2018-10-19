package medium._011_Container_With_Most_Water;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * image : question_11.jpg
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */

/**
 * 题目: 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        return 0;
    }

    public int myMaxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            if (height[i] > height[j]) {
                max = Math.max(max, height[j] * (j - i));
                j--;
            } else {
                max = Math.max(max, height[i] * (j - i));
                i++;
            }
        }
        return max;
    }

    public int solutionMaxArea(int[] height) {
        return 0;
    }

    public int faststMaxArea(int[] height) {
        int length = height.length;
        int maxAres = (length-1)*Math.min(height[0],height[length-1]);
        int temp = 0;
        int left = 0;
        int right = length-1;
        while(left<right){
            int temMax = (right-left)*Math.min(height[right],height[left]);
            if(temMax>maxAres) maxAres = temMax;
            if(height[left]<height[right]){
                temp = left;
                while(height[temp]>=height[left]&&left<right){
                    left++;
                }
            }
            else{
                temp = right;
                while(height[temp]>=height[right]&&left<right){
                    right--;
                }
            }
        }
        return maxAres;
    }
}
