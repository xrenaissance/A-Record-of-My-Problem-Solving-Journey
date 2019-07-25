package TwoPointers;
import java.util.*;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/6210874538721280
 * @leetcode https://leetcode.com/problems/4sum/
 * @author Egbert Li
 * @date 27/06/2019 -> 26/7/2019
 * @Time O N * log N + N ^ 2
 * @Space O N
 */
public class TripletSumZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> allTriplets = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return allTriplets;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            searchPair(arr, i + 1, -arr[i], allTriplets);
        }
        return allTriplets;
    }
    public static void searchPair(int[] arr, int left, int targetSum,
                                  List<List<Integer>> allTriplets) {
       int right = arr.length - 1;
       while (left < right) {
           int targetDiff = targetSum - arr[left];
           if (targetDiff > arr[right]) {
               left++;
           } else if (targetDiff < arr[right]) {
               right--;
           } else {
               allTriplets.add(Arrays.asList(-targetSum, arr[left++], arr[right--]));
               while (left < right && arr[left] == arr[left - 1]) {
                   left++;
               }
               while (left < right && arr[right] == arr[right + 1]) {
                   right--;
               }
           }
       }
    }
    public static void main(String[] args) {
        System.out.println(TripletSumZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}
