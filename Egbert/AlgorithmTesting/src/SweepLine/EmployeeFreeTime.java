package SweepLine;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/employee-free-time/
 * @Time NlogN
 * @Space N + N for sorting
 *
 * @key find the point there is no overlap at all, aka no plane in the sky,we
 * are free till next time point!!
 */
public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        if (schedule == null || schedule.size() == 0) {
            return result;
        }
        List<Point> pointList = new ArrayList<>();
        for (List<Interval> list :  schedule) {
            for (Interval i : list) {
                pointList.add(new Point(i.start, 1));
                pointList.add(new Point(i.end, -1));
            }
        }
        Collections.sort(pointList, (p1, p2) ->{
            int diff = p1.time - p2.time;
            if (diff == 0) {
                diff = p1.flag - p2.flag;
            }
            return diff;
        });
        int currOverLap = 0;
        for (int i = 0; i < pointList.size() - 1; i++) {
            currOverLap += pointList.get(i).flag;
            if (currOverLap == 0) {
                int start =  pointList.get(i).time;
                int end = pointList.get(i + 1).time;
                if (start != end) {
                    result.add(new Interval(start, end));
                }
            }
        }
        return result;
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
