package Sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @leetcode
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

    public boolean canAttendMeetingsPQ(int[][] intervals) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a1, a2) -> Integer.compare(a1[0], a2[0])
        );
        for (int[] a : intervals) {
            minHeap.offer(a);
        }
        int[] prev = null;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            if (prev == null) {
                prev = curr;
            } else {
                if (curr[0] >= prev[1]) {
                    prev = curr;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
