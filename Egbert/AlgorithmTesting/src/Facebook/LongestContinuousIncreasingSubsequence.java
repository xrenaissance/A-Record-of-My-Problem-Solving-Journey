package Facebook;

/**
 * @leetcode https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 * @Time O N
 * @pace 1
 */
public class LongestContinuousIncreasingSubsequence {
    // dp[i] = dp[i - 1] + 1 if nums[i - 1] < nums[i]
    //          else dp[i] = 1;
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int longest = 1;
        int prevLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                prevLength += 1;
            } else {
                prevLength = 1;
            }

            longest = Math.max(longest, prevLength);
        }

        return longest;
    }
}
