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
        int longest = 0;
        int curr = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 && array[i] == 1) {
                curr ++;
                longest = Math.max(curr, longest);
            } else {
                if (array[i] == 1 && array[i - 1] == 1) {
                    curr++;
                } else if (array[i] == 1) {
                    curr = 1;
                } else {
                    curr = 0;
                }
                longest = Math.max(longest, curr);
            }
        }
        return longest;
    }
}
