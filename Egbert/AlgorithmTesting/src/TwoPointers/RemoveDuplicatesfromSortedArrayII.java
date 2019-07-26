package TwoPointers;

/**
 * @leetcode https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * @date 26/7/2019
 * @Time N
 * @sapce 1
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        // [0, slow) num that no more than 2 times
        // if fast >= 2 &&  nums[fast] == nums[slow - 1] && nums[slow - 1] == nums[slow - 2] continue
        // otherwise nums[slow++] = nums[fast]
        // [slow, fast) dump
        // [fast .. rest] need to explore
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (fast < 2 || nums[fast] != nums[slow - 2]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
