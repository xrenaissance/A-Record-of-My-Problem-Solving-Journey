package SweepLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @leetcode https://www.lintcode.com/problem/number-of-airplanes-in-the-sky/description
 * @Time 2N + NlogN
 * @Space N
 * key point get maximum number of start points, start +, end -
 */
public class NumberofAirplanesintheSky {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        List<Point> points = new ArrayList<>();
        for (Interval i : airplanes) {
            points.add(new Point(i.start, 1));
            points.add(new Point(i.end, 0));
        }
        Collections.sort(points, (p1, p2) -> {
            int diff = p1.time - p2.time;
            if (diff == 0) {
                diff = p1.flag - p2.flag;
            }
            return diff;
        });
        int count = 0;
        int max = 0;
        for (Point p : points) {
            if (p.flag == 1) {
                count++;
            } else {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
    public static class Point {
        int time;
        int flag;
        public Point(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
}
