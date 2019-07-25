package TwoPointers;

/**
 * @leetcode https://leetcode.com/problems/move-zeroes/
 * @date 26/7/2016
 * @Time O N
 * @Space 1
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        // [0, nonZero) not zero
        // [nonZero, zero) zero
        int nonZero = 0;
        for (int zeroIndex = 0; zeroIndex < nums.length; zeroIndex++) {
            if (nums[zeroIndex] != 0) {
                swap(nums, nonZero++, zeroIndex);
            }
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
