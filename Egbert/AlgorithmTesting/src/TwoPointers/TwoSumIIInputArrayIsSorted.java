package TwoPointers;

/**
 * @leetcode https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/1
 * @date 26/7/2019
 * @Time O N
 * @Space 1
 */
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }
}
