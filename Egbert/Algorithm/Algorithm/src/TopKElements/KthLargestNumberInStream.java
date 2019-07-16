package TopKElements;

import java.util.PriorityQueue;

/**
 * @leetcode https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * @date 16/7/2019
 * @Time add log k
 * @Space k
 */
public class KthLargestNumberInStream {
    public PriorityQueue<Integer> minHeap;
    public final int k;
    public KthLargestNumberInStream(int[] nums, int k) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else {
                if (num > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }
    }

    public int add(int num) {
        if (minHeap.size() < k) {
            minHeap.offer(num);
        } else {
            if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}
