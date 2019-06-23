package TwoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/6618310940557312
 * @author Egbert Li
 * @Time O N
 * @Space O(1) ------ O(N)
 */
public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        int[] result =  new int[] { -1, -1 };
        if (arr == null || arr.length == 0) {
            return result;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int targetDiff = targetSum - arr[start];
            if (targetDiff > arr[end]) {
               start++;
            } else if (targetDiff < arr[end]) {
               end--;
            } else {
               result[0] = start;
               result[1] = end;
               return result;
            }
        }
        return result;
    }

    public static int[] searchHash(int[] arr, int targetSum) {
        int[] result = new int[] {-1, -1};
        if (arr == null || arr.length == 0) {
            return result;
        }
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (nums.containsKey(targetSum - arr[i])) {
                result[0] = nums.get(targetSum - arr[i]);
                result[1] = i;
                return result;
            }
            nums.put(arr[i], i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
