package ModifiedBinarySearch;

/**
 * @leetcode https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * @date 15/7/2019
 * @Time log N
 * @Space 1
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) { // right side
                end = mid;
            } else { // then left side
                start = mid + 1;
            }
        }
        return nums[start];
    }
}
