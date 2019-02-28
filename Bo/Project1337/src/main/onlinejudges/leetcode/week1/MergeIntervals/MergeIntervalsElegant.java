package main.onlinejudges.leetcode.week1.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervalsElegant {

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        List<Interval> result = new ArrayList<>();
        Interval temp = new Interval();
        for (Interval interval : intervals) {
            if (result.size() == 0 || temp.end < interval.start) {
                result.add(interval);
                temp = interval;
            } else if (temp.end < interval.end) {
                temp.end = interval.end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1, 5);
        Interval i2 = new Interval(7, 8);

        List<Interval> list = new ArrayList<Interval>();
        list.add(i1);
        list.add(i2);

        MergeIntervalsElegant solution = new MergeIntervalsElegant();
        List<Interval> result = solution.merge(list);

        for(Interval i : result) {
            System.out.println("Interval start: " + i.start);
            System.out.println("Interval end: " + i.end);
            System.out.println("--------------------");

        }

    }
}