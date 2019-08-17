package MergeIntervals;
import java.util.List;
import java.util.ArrayList;
public class InsertIntervalList {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();
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
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertIntervalList.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertIntervalList.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertIntervalList.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
