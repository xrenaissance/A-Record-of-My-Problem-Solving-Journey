package TwoPointers;

import java.util.Arrays;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5554621957275648
 * @author Egbert Li
 * @date 25/06/2019
 * @Time O N * log N + N * N
 * @Space O n
 */

public class TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        int[] count = new int[] {0};
        if (arr == null || arr.length == 0) {
            return count[0];
        }
        Arrays.sort(arr); // quick sort, time nlogn, space O n
        for (int i = 0; i < arr.length - 2; i++) {
            searchPairs(arr, i + 1, target - arr[i], count);
        }
        return count[0];
    }
    private static void searchPairs(int[] arr, int left,
                                   int target, int[] count) {
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < target) {
                count[0] += right - left;
                left++;
            } else {
                right--;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
