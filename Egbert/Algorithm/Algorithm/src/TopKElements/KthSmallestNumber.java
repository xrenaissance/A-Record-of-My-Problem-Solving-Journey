package TopKElements;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5696381570252800
 * @date 16/7/2019
 * @Time maxHeap klogk + (n-k)logk -> nlogk
 * @Space O k
 *
 * For Quick Selection
 * n + n/2 + n/4 = 2n + 1
 * @Space O 1
 */
public class KthSmallestNumber {
    // Solution 1: size k maxHeap
    public static int findKthSmallestNumber(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return -1;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                k, (a, b) -> b.compareTo(a)
        );
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                maxHeap.offer(nums[i]);
            } else {
                if (nums[i] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(nums[i]);
                }
            }
        }
        return maxHeap.peek();
    }

    // Solution 2: Quick Selection k N
    public static int findKthSmallestNumberQuickSelect(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return -1;
        }
        quickSelect(nums, 0, nums.length - 1, k - 1);
        return nums[k - 1];
    }
    private static void quickSelect(int[] nums, int left, int right, int k) {
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
        int smallerIndex = left;
        int explorIndex = left;
        while (explorIndex < right) {
            if (nums[explorIndex] <= nums[right]) {
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
    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
