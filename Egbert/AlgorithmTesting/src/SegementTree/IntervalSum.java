package SegementTree;
import java.util.*;
public class IntervalSum {





    // Solution 2: O N + O 1 query
    /**
     * @param A: An integer list
     * @param queries: An query list
     * @return: The result list
     */
    public List<Long> intervalSumNaiev(int[] A, List<Interval> queries) {
        if (A == null || A.length == 0) {
            return new ArrayList<Long>();
        }
        long[] sum = new long[A.length];
        long accSum = 0;
        for (int i = 0; i < A.length; i++) {
            accSum += A[i];
            sum[i] = accSum;
        }
        List<Long> res = new ArrayList<>();
        for (Interval iter : queries) {
            int start = iter.start;
            int end = iter.end;
            if (start - 1 >= 0) {
                res.add(sum[end] - sum[start - 1]);
            } else {
                res.add(sum[end]);
            }
        }
        return res;
    }
}
