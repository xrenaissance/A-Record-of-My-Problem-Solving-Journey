package TwoPointers;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/subarray-product-less-than-k/
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5902703286812672
 * @author Egbert Li
 * @date 28/06/2019
 * @Time O N ^ 3
 * @Space O 1 if ignoring the space required for the output list
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int windowStart = 0;
        int product = 1;
        int total = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            product *= nums[windowEnd];
            while (product >= k && windowStart < windowEnd) {
                product /= nums[windowStart++];
            }
            if (product < k) {
                total += (windowEnd - windowStart + 1);
            }
        }
        return total;
    }
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        int windowStart = 0;
        int product = 1;
        // O N
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            product *= arr[windowEnd];
            // worst case O N
            while (product >= target && windowStart < arr.length) {
                product /= arr[windowStart++];
            }
            List<Integer> tempList = new LinkedList<>();
            // outter loop: worst case O N
            // innner loop: worst case O N
            // overall O N ^ 2
            for (int i = windowEnd; i >= windowStart; i--) {
                tempList.add(0, arr[i]);
                result.add(new ArrayList<>(tempList)); // O N
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 1, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
        System.out.println(10/3);
    }
}