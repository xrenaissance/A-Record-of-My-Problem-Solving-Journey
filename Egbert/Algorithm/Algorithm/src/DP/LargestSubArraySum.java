package DP;

/**
 * @author Egbert Li
 * @date 28/04/2019
 * Time: O(n)
 * Space: O(1)
 */
public class LargestSubArraySum {
    public int largestSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        int curr = array[0];
        // dp[i] means the largest sum of subarray ending at index i
        // dp[i] = array[i] if dp[i - 1] <= 0
        //       = dp[i - 1] + array[i] if dp[i - 1] > 0
        for (int i = 1; i < array.length; i++) {
            curr = Math.max(curr + array[i], array[i]);
            result = Math.max(curr, result);
        }
        return result;
    }
}