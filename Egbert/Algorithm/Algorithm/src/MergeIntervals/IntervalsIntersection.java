package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode https://leetcode.com/problems/interval-list-intersections/
 * @Time  m + N
 * @Space m + n
 */
public class IntervalsIntersection {
    // i for arr1, j for arr2
    // i2.start <= i1.end
    // merged.start = max(i1.start, i2.start)
    // merged.end = min(i1.end, i2.end)
    // if (i1.end == i2.end) i++, j++
    // else if i1.end > i2.end i,j++
    // else i++, j
    public static MergeIntervals.Interval[] merge(MergeIntervals.Interval[] arr1, MergeIntervals.Interval[] arr2) {
        List<MergeIntervals.Interval> intervalsIntersection = new ArrayList<MergeIntervals.Interval>();
        int i = 0;
        int j = 0;
        int start = 0;
        int end = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr2[j].start > arr1[i].end) {
                i++;
            } else if (arr1[i].start > arr2[j].end) {
                j++;
            } else if (arr1[i].start <= arr2[j].end || arr2[j].start <= arr1[i].end) {
                start = Math.max(arr1[i].start, arr2[j].start);
                end = Math.min(arr1[i].end, arr2[j].end);

                if (arr1[i].end > arr2[j].end) {
                    j++;
                } else if (arr2[j].end > arr1[1].end) {
                    i++;
                } else {
                    i++;
                    j++;
                }
                intervalsIntersection.add(new MergeIntervals.Interval(start, end));
            }
        }
        return intervalsIntersection.toArray(new MergeIntervals.Interval[intervalsIntersection.size()]);
    }

    public static void main(String[] args) {
        MergeIntervals.Interval[] input1 = new MergeIntervals.Interval[] { new MergeIntervals.Interval(1, 3), new MergeIntervals.Interval(5, 6), new MergeIntervals.Interval(7, 9) };
        MergeIntervals.Interval[] input2 = new MergeIntervals.Interval[] { new MergeIntervals.Interval(2, 3), new MergeIntervals.Interval(5, 7) };
        MergeIntervals.Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (MergeIntervals.Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new MergeIntervals.Interval[] { new MergeIntervals.Interval(1, 3), new MergeIntervals.Interval(5, 7), new MergeIntervals.Interval(9, 12) };
        input2 = new MergeIntervals.Interval[] { new MergeIntervals.Interval(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (MergeIntervals.Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}
