package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervalList {
    public static List<MergeIntervals.Interval> insert(List<MergeIntervals.Interval> intervals, MergeIntervals.Interval newInterval) {
        List<MergeIntervals.Interval> mergedIntervals = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            mergedIntervals.add(newInterval);
            return mergedIntervals;
        }
        int index = 0;
        int size = intervals.size();
        // find the insert point
        while (index < size && intervals.get(index).end < newInterval.start) {
            mergedIntervals.add(intervals.get(index++));
        }
        // merge overlapped intervals
        while (index < size && intervals.get(index).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(index).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(index).end, newInterval.end);
            index++;
        }
        mergedIntervals.add(newInterval);
        while (index < size) {
            mergedIntervals.add(intervals.get(index++));
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<MergeIntervals.Interval> input = new ArrayList<MergeIntervals.Interval>();
        input.add(new MergeIntervals.Interval(1, 3));
        input.add(new MergeIntervals.Interval(5, 7));
        input.add(new MergeIntervals.Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (MergeIntervals.Interval interval : InsertIntervalList.insert(input, new MergeIntervals.Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<MergeIntervals.Interval>();
        input.add(new MergeIntervals.Interval(1, 3));
        input.add(new MergeIntervals.Interval(5, 7));
        input.add(new MergeIntervals.Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (MergeIntervals.Interval interval : InsertIntervalList.insert(input, new MergeIntervals.Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<MergeIntervals.Interval>();
        input.add(new MergeIntervals.Interval(2, 3));
        input.add(new MergeIntervals.Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (MergeIntervals.Interval interval : InsertIntervalList.insert(input, new MergeIntervals.Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
