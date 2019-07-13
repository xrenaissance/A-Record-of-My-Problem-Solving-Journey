package TwoHeaps;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/6296665940033536
 * @leetcode https://leetcode.com/problems/sliding-window-median/
 * @author Egbert Li
 * @date 13/07/2019
 * @Time N * (log K + K) -> N*K
 * @Space K
 */
import java.util.*;
public class SlidingWindowMedian {
    public double[] findSlidingWindowMedian(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new double[0];
        }
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            insertNum(nums[i], maxHeap, minHeap);
            rebalance(maxHeap, minHeap);
            if (i - k + 1 >= 0) {
                result[i - k + 1] = getMedian(maxHeap, minHeap);
                int numNeedToBeRemoved = nums[i - k + 1];
                moveWindow(numNeedToBeRemoved, maxHeap, minHeap);
                rebalance(maxHeap, minHeap);
            }
        }
        return result;
    }
    private void moveWindow(int num, PriorityQueue<Integer> maxHeap,
                            PriorityQueue<Integer> minHeap) {
        if (num <= maxHeap.peek()) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
    }
    private void insertNum(int num,
                           PriorityQueue<Integer> maxHeap,
                           PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() == 0 || num < maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
    }
    private void rebalance(PriorityQueue<Integer> maxHeap,
                           PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    private double getMedian(PriorityQueue<Integer> maxHeap,
                             PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }
}
