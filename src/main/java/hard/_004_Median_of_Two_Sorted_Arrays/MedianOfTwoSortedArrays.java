package hard._004_Median_of_Two_Sorted_Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */

/**
 * 题目: 无重复字符的最长子串
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 你可以假设 nums1 和 nums2 不同时为空。
 * <p>
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 中位数是 2.0
 * <p>
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 中位数是 (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }

    /**
     * 因为是两个有序数组,所以先想到的是互相一次对比就可以往一个容器里添加一个元素 这样时间复杂度就不会太高
     * 创建一个容器 总量只需要填满 两个数组+1 的大小就可以
     * 如果两个数组长度和是单数 那么直接取最后一个元素就是中位数
     * 如果是双数 那么把最后两个元素相加除以2就是中位数
     * 注意: 要考虑元素角标越界的问题
     */
    public double myFindMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;
        int[] ints = new int[totalLength / 2 + 1];
        int length = ints.length;
        int index1 = 0;
        int index2 = 0;
        int totalIndex = 0;
        while (totalIndex < length) {
            if (index1 >= length1) {
                ints[totalIndex] = nums2[index2++];
            } else if (index2 >= length2) {
                ints[totalIndex] = nums1[index1++];
            } else if (nums1[index1] < nums2[index2]) {
                ints[totalIndex] = nums1[index1++];
            } else {
                ints[totalIndex] = nums2[index2++];
            }
            totalIndex++;
        }
        if (totalLength % 2 == 0) {
            return (ints[length - 1] + ints[length - 2]) / 2.0;
        } else {
            return ints[length - 1] / 1.0;
        }
    }

    /**
     * 太难理解了....
     */
    public double solutionFindMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        //先确保A的长度要比B长度长 如果A长度小于B 那么互相交换 ,中位数一定出现在A 数组里
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        //遍历 0 到A的长度
        while (iMin <= iMax) {
            //折半
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {//如果 B比A 大说明A应该把角标向右移动
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {//如果A比B大 说明应该把角标向左移动
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public double faststFindMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return faststFindMedianSortedArrays(nums2, nums1);
        int len = nums1.length + nums2.length;
        int n = nums1.length, m = nums2.length;
        int cut1 = 0, cut2 = 0;
        int left = 0, right = nums1.length;
        int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
        int sum = 0;

        while (cut1 <= n) {
            cut1 = (right - left) / 2 + left;
            cut2 = len / 2 - cut1;
            int cut1L = cut1 == 0 ? MIN : nums1[cut1 - 1];
            int cut1R = cut1 == n ? MAX : nums1[cut1];
            int cut2L = cut2 == 0 ? MIN : nums2[cut2 - 1];
            int cut2R = cut2 == m ? MAX : nums2[cut2];

            if (cut1R < cut2L) {
                left = cut1 + 1;
            } else if (cut1L > cut2R) {
                right = cut1 - 1;
            } else {
                if (len % 2 == 0) {
                    sum = Integer.max(cut1L, cut2L) + Integer.min(cut1R, cut2R);
                    return (double) sum / 2;
                } else {
                    return Integer.min(cut1R, cut2R);
                }
            }
        }
        return -1;
    }
}