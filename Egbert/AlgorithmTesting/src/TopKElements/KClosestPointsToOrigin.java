package TopKElements;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static List<Point> findClosestPoints(Point[] points, int k) {
        ArrayList<Point> result = new ArrayList<>();
        if (points == null || points.length == 0) {
            return result;
        }
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(
            k, (a, b) -> Integer.compare(b.distFromOrigin(), a.distFromOrigin())
        );
        for (int i = 0; i < points.length; i++) {
            if (i < k) {
                maxHeap.offer(points[i]);
            } else {
                if (points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()) {
                    maxHeap.poll();
                    maxHeap.offer(points[i]);
                }
            }
        }
        return new ArrayList<Point>(maxHeap);
    }

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result) {
            System.out.print("[" + p.x + " , " + p.y + "] ");
        }
    }
}
