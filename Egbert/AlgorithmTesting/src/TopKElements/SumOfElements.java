package TopKElements;

import java.util.PriorityQueue;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5648269346603008
 * @date 17/7/2019
 * @Time n log k2 + (k2 - k1 - 1) log k2
 * @Space K2
 */
public class SumOfElements {
    public static int findSumOfElements(int[] nums, int k1, int k2) {
        if (nums == null || nums.length < k2) {
            return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            k2 - 1, (a, b) -> Integer.compare(b, a)
        );
        for (int num : nums) {
            if (maxHeap.size() < k2 - 1) {
                maxHeap.offer(num);
            } else {
                if (num < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(num);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < k2 - k1 - 1; i++) {
            sum += maxHeap.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}
