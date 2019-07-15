package ModifiedBinarySearch;

/**
 * @leetcode https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * @Date 15/7/2019
 * @Time worst N, best log N
 * @Space 1
 */
public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                start++;
                end--;
            } else {
                if (nums[mid] <= nums[end]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
        }
        return nums[start];
    }
}
