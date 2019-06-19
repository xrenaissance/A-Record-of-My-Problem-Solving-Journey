package SlidingWindow;
//Problem Statement
//        Given an array containing 0s and 1s, if you are allowed to replace
//        no more than ‘k’ 0s with 1s, find the length of the longest subarray
//        having all 1s.

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/4867522786492416
 * @author Egbert Li
 * @date 19/06/2019
 * @Time O N
 * @Space O 1
 */
public class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int windowStart = 0;
        int maxLength = 0;
        int maxOneCount = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1) {
                maxOneCount++;
            }
            if (windowEnd - windowStart + 1 - maxOneCount > k) {
                if (arr[windowStart] == 1) {
                    maxOneCount--;
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
