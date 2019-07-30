package TagedByCompany.GoldManSachs;

/**
 * @leetcode https://leetcode.com/problems/minimum-size-subarray-sum/
 * @Time N
 * @Space 1
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int windowStart = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            sum += nums[windowEnd];
            while (sum >= s) {
                min = Math.min(min, windowEnd - windowStart + 1);
                sum -= nums[windowStart];
                windowStart++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
