package MergeIntervals;
import java.util.*;

/**
 * @leetcdoe https://leetcode.com/problems/insert-interval/
 * @Time N
 * @N
 */
public class InsertIntervalLeetcode {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {1,3},
                {6,9}
        };
        int[] newInterval = new int[] {2, 5};
        InsertIntervalLeetcode iil = new InsertIntervalLeetcode();
        int[][]  output = iil.insert(intervals, newInterval);
        for (int[] i : output) {
            System.out.println(i[0] + " " + i[1]);
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[][]{newInterval};
        }
        int index = 0;
        int length = intervals.length;
        List<int[]> res = new ArrayList<>();
        while (index < length && intervals[index][1] < newInterval[0]) {
            res.add(intervals[index++]);
        }
        while (index < length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            index++;
        }
        res.add(newInterval);
        while (index < length) {
            res.add(intervals[index++]);
        }
        int[][] output = new int[res.size()][2];
        index = 0;
        for (; index < res.size(); index++) {
            output[index] = res.get(index);
        }
        return output;
    }
}
