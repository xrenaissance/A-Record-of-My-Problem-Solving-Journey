package MergeIntervals;

import java.util.Arrays;

public class ConflictingAppointments {
    public static boolean canAttendAllAppointments(MergeIntervals.Interval[] intervals) {
        if (intervals == null || intervals.length == 0)  {
            return true;
        }
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start <= intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MergeIntervals.Interval[] intervals = { new MergeIntervals.Interval(1, 4), new MergeIntervals.Interval(2, 5), new MergeIntervals.Interval(7, 9) };
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        MergeIntervals.Interval[] intervals1 = { new MergeIntervals.Interval(6, 7), new MergeIntervals.Interval(2, 4), new MergeIntervals.Interval(8, 12) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        MergeIntervals.Interval[] intervals2 = { new MergeIntervals.Interval(4, 5), new MergeIntervals.Interval(2, 3), new MergeIntervals.Interval(3, 6) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}
