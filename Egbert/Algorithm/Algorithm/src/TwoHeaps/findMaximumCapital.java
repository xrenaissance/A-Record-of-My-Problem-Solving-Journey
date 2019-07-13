package TwoHeaps;
import java.util.PriorityQueue;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/48911205112217601
 * @leetcode https://leetcode.com/problems/ipo/
 * @author Egbert Li
 * @date 13/7/2019
 * @Time worst case: all of the projects are pushed to minHeap N log N + k * log N
 * @Space worst O N
 */
public class MaximizeCapital {
    public static int findMaximumCapital(int[] capital, int[] profits,
                                         int numberOfProjects,
                                         int initialCapital) {
        if (capital == null || capital.length == 0) {
            return 0;
        }
        int length = capital.length;
        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(
                length, (a, b) -> Integer.compare(capital[a], capital[b])
        );
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(
                length, (a, b) -> Integer.compare(profits[b], profits[a])
        );

        // N log N
        for (int i = 0; i < capital.length; i++) {
            minCapitalHeap.offer(i);
        }
        int currCapital = initialCapital;
        // K times
        for (int i = 0; i < numberOfProjects; i++) {
            // worst case log N
            while (!minCapitalHeap.isEmpty() &&
                    currCapital >= capital[minCapitalHeap.peek()]) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            // log N
            currCapital += profits[maxProfitHeap.poll()];
        }
        return currCapital;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}
