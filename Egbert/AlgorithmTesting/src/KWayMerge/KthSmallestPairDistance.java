package KWayMerge;
import java.util.PriorityQueue;
import java.util.Arrays;
public class KthSmallestPairDistance {
    public static int smallestDistancePair(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (v1, v2) -> v2 - v1
        );

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // System.out.println("peek value: " + maxHeap.peek());
                // if (maxHeap.peek() != null) {
                //    System.out.println("abs: " + Math.abs(nums[i] - nums[j]));
                // }
                // System.out.println();
                if (maxHeap.size() < k) {
                    maxHeap.offer(Math.abs(nums[i] - nums[j]));
                } else {
                    if (Math.abs(nums[i] - nums[j]) <= maxHeap.peek()) {
                        maxHeap.poll();
                        maxHeap.offer(Math.abs(nums[i] - nums[j]));
                    }
                }
            }
        }
        return maxHeap.peek();
    }
    public static void main(String[] args) {
        int[] input1 = new int[] {1, 3, 4, 9,3,4,3, 45,6};
        System.out.println(KthSmallestPairDistance.smallestDistancePair(input1, 4));
    }
}

