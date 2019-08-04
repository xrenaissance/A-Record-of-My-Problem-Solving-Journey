package BitOperation;

/**
 * @leetcode https://leetcode.com/problems/single-number/
 * @Time N
 * @Space 1
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
