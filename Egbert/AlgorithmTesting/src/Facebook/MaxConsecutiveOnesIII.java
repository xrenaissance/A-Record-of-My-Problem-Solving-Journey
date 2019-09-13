package Facebook;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int windowStart = 0;
        int longest = 0;
        int count = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 0) {
                count++;
            }

            while (count > k) {
                if (nums[windowStart] == 0) {
                    count--;
                }

                windowStart++;
            }

            longest = Math.max(longest, windowEnd - windowStart + 1);
        }

        return longest;
    }
}
