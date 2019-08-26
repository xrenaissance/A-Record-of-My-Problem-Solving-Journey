package CyclicSort;

/**
 * @leetcode https://leetcode.com/problems/first-missing-positive/
 * @Time N
 * @Space 1
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int index = 0;
        while (index < nums.length) {
            if (nums[index] > 0 && nums[index] <= nums.length
                    && nums[index] != nums[nums[index] - 1]) {
                swap(nums, index, nums[index] - 1);
            } else {
                index++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
