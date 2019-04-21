package DP;

/**
 * @author Egbert Li
 * @date 20/04/2019
 * Time: O(N)
 * Space: O(N)
 */
public class LongestAscendingSubArray {
    // M[i] = {i > 0 && i < n | M[i - 1] + 1 if array[i - 1] < array[i] else 1}
    public int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] currLongest = new int[array.length + 1];
        int longest = 1;
        currLongest[0] = 1;
        for (int i = 1; i < currLongest.length - 1; i++) {
            if (array[i] > array[i - 1]) {
                currLongest[i] = currLongest[i - 1] + 1;
                longest = Math.max(longest, currLongest[i]);
            } else {
                currLongest[i] = 1;
            }
        }
        return longest;
    }
}
