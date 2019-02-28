package main.java.onlinejudges.leetcode.week1.MergeIntervals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        List<Interval> result = new ArrayList<>();
        Interval temp = new Interval();
        for (Interval interval : intervals) {
            if (result.size() == 0) {
                result.add(interval);
                temp = interval;
            } else if (temp.end >= interval.start && temp.end < interval.end) {
                temp.end = interval.end;
            } else if (temp.end < interval.start) {
                temp = interval;
                result.add(interval);
            }
        }

        return result;
    }

}
