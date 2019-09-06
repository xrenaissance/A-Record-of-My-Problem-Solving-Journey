package Amazon;
import java.util.PriorityQueue;
import java.util.Comparator;
public class KCloestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>(new Comparator<int[]>() {
                    public int compare(int[] one, int[] two) {
                        int oneDistance = one[0] * one[0] + one[1] * one[1];
                        int twoDistance = two[0] * two[0] + two[1] * two[1];
                        if (oneDistance == twoDistance) {
                            return 0;
                        }
                        return oneDistance > twoDistance ? -1 : 1;
                    }
                });
        for (int i = 0; i < points.length; i++) {
            if (i < K) {
                minHeap.offer(points[i]);
            } else {
                if (getDistance(points[i]) < getDistance(minHeap.peek())) {
                    minHeap.poll();
                    minHeap.offer(points[i]);
                }
            }
        }
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
