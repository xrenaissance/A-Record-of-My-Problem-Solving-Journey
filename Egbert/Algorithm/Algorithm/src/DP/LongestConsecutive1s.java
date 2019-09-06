package DP;

/**
 * @author Egbert Li
 * @date 28/04/2019
 * Time: O(N)
 * Space: O(1)
 */
public class LongestConsecutive1s {
    public int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int curr = 0;
        int longest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                if (i == 0 || array[i - 1] == 0) {
                    curr = 1;
                } else {
                    curr++;
                }
            }
            longest = Math.max(curr, longest);
        }
        return longest;
    }
}
