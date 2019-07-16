package TopKElements;
import java.util.*;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5474975244877824
 * @date 16/7/2019
 * @Time log N + 2k + klogk
 * @Space k
 */
public class KClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, Integer x) {
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
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
               start = mid + 1;
            } else {
                return mid;
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
    }
}
