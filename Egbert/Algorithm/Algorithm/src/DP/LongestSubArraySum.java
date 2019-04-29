package DP;

/**
 * @author Egbert Li
 * @date 28/04/2019
 * Time: O(N ^ 2)
 * Space: O(N)
 */
public class LongestSubArraySum {

    // M[i] represent the longest length for 0 to the ith index
    public int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] longest = new int[array.length];
        for (int i = 0; i < longest.length; i++) {
            longest[i] = 1;
        }
        int lgst = 1;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    longest[i] = Math.max(longest[i], longest[j] + 1);
                }
                lgst = Math.max(lgst, longest[i]);
            }
        }
        return lgst;
    }
}
