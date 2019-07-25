package TwoPointers;

/**
 * @leetcode https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @date 26/7/2016
 * @Time N
 * @Space 1
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int slow = 1;
        // [0, slow) unique numbers
        // [slow, fast) dump
        // [fast...] explore
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 1]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
