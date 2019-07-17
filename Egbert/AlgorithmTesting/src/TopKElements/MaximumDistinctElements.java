package TopKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5741384237580288
 * @date 17/7/2019
 * @Time N + k log D
 * @Space N + D
 */
public class MaximumDistinctElements {
    public static int findMaximumDistinctElements(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return 0;
        }
        // O N
        Map<Integer, Integer> freqMap = getFreqMap(nums);
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            k, (a, b) -> Integer.compare(a.getValue(), b.getValue())
        );
        int total = 0;
        // D log D
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                total++;
            } else{
                minHeap.offer(entry);
            }
        }
        // k log N
        while (!minHeap.isEmpty() && k > 0) {
            int currFreq = minHeap.peek().getValue();
            if (currFreq - k <= 1) {
                total++;
                k -= (currFreq - 1);
                minHeap.poll();
            } else {
                k -= currFreq;
            }
        }
        return k > 0 ? total - k : total;
    }
    private static Map<Integer, Integer> getFreqMap(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        return freqMap;
    }
    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5}, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 5, 7, 5, 5, 1, 2, 2 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}
