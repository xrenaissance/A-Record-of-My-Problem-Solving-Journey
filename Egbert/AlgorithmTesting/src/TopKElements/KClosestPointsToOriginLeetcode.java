package TopKElements;
import java.util.PriorityQueue;

/**
 * @leetcode https://leetcode.com/problems/k-closest-points-to-origin/
 * @date 16/7/2019
 * @Time nlogk
 * @Space k
 */
public class KClosestPointsToOriginLeetcode {
    public int[][] kClosest(int[][] points, int K) {
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
