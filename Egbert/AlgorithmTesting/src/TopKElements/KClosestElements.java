package TopKElements;
import java.util.*;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5474975244877824
 * @leetcode https://leetcode.com/problems/find-k-closest-elements/
 * @date 16/7/2019
 * @Time log N + 2k + klogk
 * @Space k
 *
 * Binary Search
 * @Time log N + k
 * @Space 1
 */
public class KClosestElements {
    // Solution 1: two pointers - binary search
    // log N for finding index of the largest smaller than target
    // k for finding k closest numubers
    public static List<Integer> findClosestElements(int[] arr, int k, Integer x) {
        List<Integer> result = new LinkedList<Integer>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        int index = getLargestSmallerTarget(arr, x);
        int left = index;
        int right = index + 1;
        for (int i = 0; i < k; i++) {
            if (left >= 0 && right < arr.length) {
                int leftDiff = Math.abs(x - arr[left]);
                int rightDiff = Math.abs(x - arr[right]);
                if (leftDiff <= rightDiff) {
                    result.add(0, arr[left--]);
                } else {
                   result.add(arr[right++]);
                }
            } else if (left >= 0) {
                result.add(0, arr[left--]);
            } else if (right < arr.length) {
                result.add(arr[right++]);
            }
        }
        return result;
    }

    // Solution 2: MiniHeap solution
    public static List<Integer> findClosestElementsMiniHeap(int[] arr, int k, Integer x) {
        List<Integer> result = new ArrayList<>();
        int cloestIndex = getLargestSmallerTarget(arr, x);
        int low = Math.max(0, cloestIndex - k);
        int high = Math.min(arr.length - 1, cloestIndex + k);
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            k, (a, b) -> a.getKey().compareTo(b.getKey())
        );
        for (int i = low; i <= high; i++) {
            minHeap.offer(new AbstractMap.SimpleEntry<>(Math.abs(arr[i] - x), arr[i]));
        }
        // k log k
        for (int i = 0; i < k; i++) {
            result.add(minHeap.poll().getValue());
        }
        Collections.sort(result);
        return result;
    }
    public static int getLargestSmallerTarget(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
               start = mid + 1;
            }
        }
        return start > 0 ? start - 1 : start;
    }
    public static void main(String[] args) {
        List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        System.out.println("--------------------------");
        System.out.println(KClosestElements.getLargestSmallerTarget(new int[] { 2, 4, 5, 6, 9 }, 10));
    }
}
