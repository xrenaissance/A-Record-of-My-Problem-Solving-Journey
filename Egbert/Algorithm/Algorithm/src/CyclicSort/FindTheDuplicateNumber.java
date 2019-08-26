package CyclicSort;

/**
 * @leetcode https://leetcode.com/problems/find-the-duplicate-number/
 * @Time N
 * @Space 1
 */
public class FindTheDuplicateNumber {



    // Solution 2: Cyclic sort with modifying array
    public int findDuplicateCS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != index + 1) {
                if (nums[index] != nums[nums[index] - 1]) {
                    swap(nums, index, nums[index] - 1);
                } else {
                    return nums[index];
                }
            } else {
                index++;
            }
        }
        return -1;
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
