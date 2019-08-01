package Array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @leetcode https://leetcode.com/problems/third-maximum-number/
 * @Time n log3  log3 is small enough,so it's still n
 * @space 3 + 3
 */
public class ThirdMaximumNumber {
    // Solution 1:
    public int thirdMaxToron(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = first;
        long third = first;
        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (first > num && num > second) {
                third = second;
                second = num;
            } else if (second > num && num > third) {
                third = num;
            }
        }
        return (int)(third == Long.MIN_VALUE ? first : third);
    }

    // heap solution
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.add(num)) {
                if (minHeap.size() < 3) {
                    minHeap.offer(num);
                } else {
                    if (num > minHeap.peek()) {
                        set.remove(minHeap.poll());
                        minHeap.offer(num);
                    }
                }
            }
        }
        if (minHeap.size() < 3) {
            while(minHeap.size() > 1) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
