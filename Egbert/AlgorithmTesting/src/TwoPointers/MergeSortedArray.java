package TwoPointers;

/**
 * @leetcode https://leetcode.com/problems/merge-sorted-array/
 * @date 20/7/2019
 * @Time m + n
 * @Space 1
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int right1 = m - 1;
        int right2 = n - 1;
        int index = m + n - 1;
        while (right1 >= 0 && right2 >= 0) {
            if (nums1[right1] >= nums2[right2]) {
                nums1[index--] = nums1[right1--];
            } else {
                nums1[index--] = nums2[right2--];
            }
        }
        while (right2 >= 0) {
            nums1[index--] = nums2[right2--];
        }
    }
}
