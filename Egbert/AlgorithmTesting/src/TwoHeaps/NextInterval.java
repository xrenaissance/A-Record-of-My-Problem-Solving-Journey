package TwoHeaps;

import java.util.PriorityQueue;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5028748841713664
 * @author Egbert Li
 * @date 13/07/2019
 * @Time N log N
 * @Space O 2 * N
 */
public class NextInterval {
    public static int[] findNextInterval(Interval[] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        // heap for finding the maximum start
        PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(
            n, (index1, index2) -> Integer.compare(intervals[index2].start,
                intervals[index1].start)
        );
        PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(
            n, (index1, index2) -> Integer.compare(intervals[index2].end,
                intervals[index1].end)
        );
        // N log N
        for (int i = 0; i < intervals.length; i++) {
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        }
        // N log N
        // go through all the intervals to find each intervals's next interval
        for (int i = 0; i < n; i++) {
            // let's find the next interval of the interval which has the highest 'end'
            int topEnd = maxEndHeap.poll();
            result[topEnd] = -1;
            // find the interval that has the closest start
            if (intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                int topStart = maxStartHeap.poll();
                while (!maxStartHeap.isEmpty() &&
                       intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                    topStart = maxStartHeap.poll();
                }
                result[topEnd] = topStart;
                maxStartHeap.offer(topStart);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }
}
