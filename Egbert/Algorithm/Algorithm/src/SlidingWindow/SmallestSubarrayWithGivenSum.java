package SlidingWindow;

/**
 * @author Egbert Li
 * @date 13/06/2019
 * @Time O(n)
 * @Space O(1)
 */
public class SmallestSubarrayWithGivenSum {
    public static int findMinSubArray(int S, int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int windowStart = 0;
        int windowSum = 0;
        int min = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // shrink the window as small as possible until the windowSum is smaller than S
            while (windowSum >= S) {
                min = Math.min(min, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public static void main(String[] args) {
        int result = SmallestSubarrayWithGivenSum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = SmallestSubarrayWithGivenSum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = SmallestSubarrayWithGivenSum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
