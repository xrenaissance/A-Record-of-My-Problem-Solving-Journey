package TopKElements;
import java.util.*;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5761493274460160
 * @leetcode https://leetcode.com/problems/top-k-frequent-elements/
 * @date 16/7/2019
 * @Time nlogk for minHeap
 * @Space N + k for minHeap
 *
 * Bucket sort
 * @Time 3 N
 * @Space 2 N
 */
public class TopKFrequentNumbers {
    // Solution 1: Bucket Time: 3N  space: N + N -> 2N
   public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);
        if (nums == null || nums.length == 0) {
            return topNumbers;
        }

        // O N
        Map<Integer, Integer> numFreq = getFrequent(nums);
        List<Integer>[] bucket = new List[nums.length + 1];
        // O N
        for (Integer key : numFreq.keySet()) {
            int frequency = numFreq.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        // O N
        for (int freq = bucket.length - 1; freq >= 0 && topNumbers.size() < k; freq--) {
            if (bucket[freq] != null) {
                for (int j = 0; j < bucket[freq].size() && topNumbers.size() < k; j++) {
                    topNumbers.add(bucket[freq].get(j));
                }
            }
        }
        return topNumbers;
    }

    // Solution 2: minHeap
    public static List<Integer> findTopKFrequentNumbersMinHeap(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);
        if (nums == null || nums.length == 0) {
            return topNumbers;
        }
        Map<Integer, Integer> numFreq = getFrequent(nums);
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(k, (a, b) -> a.getValue().compareTo(b.getValue()));
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            if (i < k) {
                minHeap.offer(entry);
            } else {
                if (entry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
            i++;
        }
        while (!minHeap.isEmpty()) {
            topNumbers.add(minHeap.poll().getKey());
        }
        return topNumbers;
    }
    private static Map<Integer, Integer> getFrequent(int[] nums) {
        Map<Integer, Integer> numFrequent = new HashMap<>();
        for (int num : nums) {
            numFrequent.put(num, numFrequent.getOrDefault(num, 0) + 1);
        }
        return numFrequent;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
