package TopKElements;

import java.util.PriorityQueue;

public class KClosest {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        if (points == null || k > points.length) {
            return new Point[0];
        }
        PriorityQueue<Point> minHeap = new PriorityQueue<>(k, (p1, p2) -> {
            int diff = distance(p2, origin) - distance(p1, origin);
            if (diff == 0) {
                diff = p2.x - p1.x;
            }
            if (diff == 0) {
                diff = p2.y - p1.y;
            }
            return diff;
        });
        Point[] res = new Point[k];
        for (Point p : points) {
            minHeap.offer(p);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = minHeap.poll();
        }
        return res;
    }
    private int distance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) +
                (p1.y - p2.y) * (p1.y - p2.y);
    }
    public static class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
    }
    public static void main(String[] args) {
        return;
    }
}
