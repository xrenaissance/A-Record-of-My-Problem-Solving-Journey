package TwoPointers;
import java.util.Arrays;

/**
 * @leetcode https://leetcode.com/problems/two-sum-less-than-k/
 * @date 26/2019
 * @Time N + nlogn
 * @Space n  sorting
 */
public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int max = -1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                max = Math.max(sum, max);
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
