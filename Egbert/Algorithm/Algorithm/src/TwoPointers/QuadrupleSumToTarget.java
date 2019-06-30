package TwoPointers;
import java.util.*;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5796496094003200
 * @author Egbert Li
 * @date 30/06
 * @Time NlogN + N ^ 3
 * @Space O N
 */
public class QuadrupleSumToTarget {
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return quadruplets;
        }
        Arrays.sort(arr); // Time:NlogN Space:O N
        // N ^ 3
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            // N ^ 2
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }
                int targetSum = target - arr[i] - arr[j];
                searchPairs(arr, i, j, targetSum, quadruplets);
            }
        }
        return quadruplets;
    }
    private static void searchPairs(int[] arr, int first,
                                    int second, int target,
                                    List<List<Integer>> quadruplets) {
        int tempSecond = second;
        int start = second + 1;
        int end = arr.length - 1;
        while (start < end) {
            int leftDiff = target - arr[start];
            if (leftDiff < arr[end]) {
                end--;
            } else if (leftDiff > arr[end]) {
                start++;
            } else {
                quadruplets.add(Arrays.asList(arr[first],
                        arr[tempSecond], arr[start++], arr[end--]));
                while (start < end && arr[start] == arr[start - 1]) {
                    start++;
                }
                while (start < end && arr[end] == arr[end + 1]) {
                    end--;
                }
            }
        }
    }
    public static void main(String[] args) {
        // -3, -1, 1, 1,
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
    }
}
