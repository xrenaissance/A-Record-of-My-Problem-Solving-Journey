package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            int currStart = interval.start;
            int currEnd = interval.end;
            if (currStart <= end) {
                end = Math.max(end, currEnd);
            } else {
                result.add(new Interval(start, end));
                start = currStart;
                end = currEnd;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
    public static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
