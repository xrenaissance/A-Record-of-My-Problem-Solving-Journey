package TopKElements;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5728885882748928
 * @leetcode https://leetcode.com/problems/kth-largest-element-in-an-array/
 * @Time minHeap: (N+k)logk
 * @Space k
 */
public class KLargestNumbers {
    // Solution 1: quick select with decending order
    private static  void quickSelect(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(nums, left, right);
        if (pivotIndex == k) {
            return;
        } else if (pivotIndex > k) {
            quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            quickSelect(nums, pivotIndex + 1, right, k);
        }
    }
    private static int partition(int[] nums, int left, int right) {
        Random random = new Random();
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(nums, randomIndex, right);
        // [0, smallerIndex) smaller
        // [smallerIndex, right) bigger
        int smallerIndex = left;
        int explorIndex = left;
        while (explorIndex < right) {
            if (nums[explorIndex] >= nums[right]) {
                swap(nums, smallerIndex++, explorIndex);
            }
            explorIndex++;
        }
        swap(nums, smallerIndex, right);
        return smallerIndex;
    }
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    // Solution 2: MiniHeap real-time algorithm
    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        // n log n
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                minHeap.offer(nums[i]);
            } else {
                if (nums[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
        // k log k
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
