package TopKElements;

import java.util.PriorityQueue;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5668515822436352
 * @date 16/7/2019
 * @Time NlogN
 * @Space N
 */
public class ConnectRopes {
    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        if (ropeLengths == null || ropeLengths.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(ropeLengths.length);
        for (int i = 0; i < ropeLengths.length; i++) {
            minHeap.offer(ropeLengths[i]);
        }
        int currCost = 0;
        int totalCost = 0;
        while (minHeap.size() > 1) {
            currCost = minHeap.poll() + minHeap.poll();
            totalCost += currCost;
            minHeap.offer(currCost);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}
