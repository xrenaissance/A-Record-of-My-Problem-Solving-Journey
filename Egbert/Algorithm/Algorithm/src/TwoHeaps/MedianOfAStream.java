package TwoHeaps;

/**
 * @leetcode https://leetcode.com/problems/find-median-from-data-stream/
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/6308926461050880
 * @author Egbert Li
 * @date 13/07/2019
 * @Time O log N
 * @Space O N  it will always store all of data
 */

import java.util.PriorityQueue;
public class MedianOfAStream {
    PriorityQueue<Integer> maxHeap; // containing first half of numbers
    PriorityQueue<Integer> minHeap; // containing second half of numbers
    public MedianOfAStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        minHeap = new PriorityQueue<>((a, b) -> a.compareTo(b));
    }
    public void insertNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        // either both the heaps will have equal number of elements
        // or maxHeap will have one more element than minHeap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // we have even number of elements, take the average of mid
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        // because maxheap will have one more element than minheap
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
