package MergeIntervals;
import java.util.Arrays;

/**
 * @leetcode https://leetcode.com/problems/meeting-rooms/
 * @Time NlogN
 * @Space N  sorting
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
