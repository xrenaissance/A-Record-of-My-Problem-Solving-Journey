package DP;

/**
 * @author Egbert Li
 * @date 20/04/2019
 * States representation:
 * M[i] = {i > 0 && i < n | M[i - 1] + 1 if array[i - 1] < array[i] else 1}
 * Time: O(N)
 * Space: O(1)
 */
public class LongestAscendingSubArray {
    public int longest(int[] array) {
        // Assumptions: the given array is not null
        if (array == null || array.length == 0) {
            return 0;
        }
        int curr = 1;
        int longest = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                curr++;
                longest = Math.max(longest, curr);
            } else {
                curr = 1;
            }
        }
        return longest;
    }
}
