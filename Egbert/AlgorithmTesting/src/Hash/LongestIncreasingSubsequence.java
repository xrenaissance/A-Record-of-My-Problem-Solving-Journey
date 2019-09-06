package Hash;

public class LongestIncreasingSubsequence {



    /**
     * @Solution2 Dynamic programming
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     * @Time N ^ 2
     * @Space N
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        // dp[i] = the longest increasing subsequence from [0, i] at index i
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
