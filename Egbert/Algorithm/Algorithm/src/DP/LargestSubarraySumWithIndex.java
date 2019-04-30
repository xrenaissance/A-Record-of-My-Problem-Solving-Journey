package DP;

/**
 * @author Egbert Li
 * @date 30/04/2019
 * Time: O(N)
 * Space: O(1)
 */
public class LargestSubarraySumWithIndex {
    public int[] largestSum(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        int curr = array[0];
        int largestSoFar = array[0];
        int[] result = new int[]{array[0], 0, 0};
        int tempStart = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > curr + array[i]) {
                tempStart = i;
            }
            curr = Math.max(array[i], curr + array[i]);
            if (curr > result[0]) {
                result[0] = curr;
                result[2] = i;
                if (tempStart != result[1]) {
                    result[1] = tempStart;
                }
            }
        }
        return result;
    }
}
