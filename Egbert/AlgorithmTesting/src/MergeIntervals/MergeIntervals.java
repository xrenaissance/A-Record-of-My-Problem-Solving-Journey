package MergeIntervals;
import java.util.*;
/**
 * @leetcode https://leetcode.com/problems/merge-intervals/
 * @Time NlogN
 * @Space N for sorting
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        int slow = 0;
        // [0, slow) merged interval
        // [slow, fast) dump
        // [fast, rest] explore
        for (int fast = 1; fast < intervals.length; fast++) {
            int currStart = intervals[fast][0];
            int currEnd = intervals[fast][1];
            if (currStart <= end) {
                end = Math.max(end, currEnd);
            } else {
                intervals[slow][0] = start;
                intervals[slow][1] = end;
                slow++;
                start = currStart;
                end = currEnd;
            }
        }
        intervals[slow][0] = start;
        intervals[slow][1] = end;
        return Arrays.copyOf(intervals, slow + 1);
    }
}
