package SweepLine;
import java.util.*;
/**
 * @leetcode https://leetcode.com/problems/meeting-rooms-ii/
 * @Time NlogN
 * @Space N + N for sorting
 *
 * @keyPoint exactly same as number of airplanes, get the maximum
 * start points at a certain time intervals
 */
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        List<Point> timePoints = new ArrayList<>();
        for (int[] i : intervals) {
            timePoints.add(new Point(i[0], 1));
            timePoints.add(new Point(i[1], -1));
        }
        int count = 0;
        int max = 0;
        Collections.sort(timePoints, (p1, p2) -> {
            int diff = p1.time - p2.time;
            if (diff == 0) {
                diff = p1.flag - p2.flag;
            }
            return diff;
        });
        for (Point p : timePoints) {
            count += p.flag;
            max = Math.max(max, count);
        }
        return max;
    }
    private static class Point {
        int time;
        int flag;
        public Point(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
}
