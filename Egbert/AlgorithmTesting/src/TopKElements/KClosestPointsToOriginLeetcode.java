package TopKElements;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Random;
/**
 * @leetcode https://leetcode.com/problems/k-closest-points-to-origin/
 * @date 16/7/2019
 * @Time nlogk
 * @Space k
 */
public class KClosestPointsToOriginLeetcode {
    // Solution 1: quickSelection
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || k > points.length) {
            return new int[0][];
        }
        quickSelect(points, 0, points.length - 1, k - 1);
        int[][] result = Arrays.copyOf(points, k);
        Arrays.sort(result,
                (a, b) -> Integer.compare(getDistance(a), getDistance(b)));
        return result;
    }
    private void quickSelect(int[][] points, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(points, left, right);
        if (pivotIndex == k) {
            return;
        } else if (pivotIndex > k) {
            quickSelect(points, left, pivotIndex - 1, k);
        } else {
            quickSelect(points, pivotIndex + 1, right, k);
        }
    }
    private int partition(int[][] points, int left, int right) {
        Random random = new Random();
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(points, randomIndex, right);
        int smallerIndex = left;
        int explorIndex = left;
        int pivotDistance = getDistance(points[right]);
        while (explorIndex < right) {
            if (getDistance(points[explorIndex]) < pivotDistance) {
                swap(points, smallerIndex++, explorIndex);
            }
            explorIndex++;
        }
        swap(points, smallerIndex, right);
        return smallerIndex;
    }
    private void swap(int[][] points, int left, int right) {
        int[] temp = points[left];
        points[left] = points[right];
        points[right] = temp;
    }

    // Solution 2: maxHeap
    public int[][] kClosestMiniHeap(int[][] points, int K) {
        if (points == null || K > points.length) {
            return new int[0][];
        }
        int[][] result = new int[K][];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                K, (a, b) -> Integer.compare(getDistance(b) , getDistance(a))
        );
        for (int i = 0; i < points.length; i++) {
            if (i < K) {
                maxHeap.offer(points[i]);
            } else {
                if (getDistance(points[i]) < getDistance(maxHeap.peek())) {
                    maxHeap.poll();
                    maxHeap.offer(points[i]);
                }
            }
        }
        for (int i = K - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
