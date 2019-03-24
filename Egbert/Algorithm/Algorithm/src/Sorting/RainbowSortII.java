package Sorting;
import java.util.PriorityQueue;
public class RainbowSortII {
    public int[] rainbowSortIIMinHeapSolution(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        // List<Integer> arrayCopy = new ArrayList<Integer>();
        // for (int elem : array) {
        //  arrayCopy.add(elem);
        // }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        // nlogn
        for (int i = 0; i < array.length; i++) {
            minHeap.offer(array[i]);
        }
        int i = 0;
        //nlogn
        while (!minHeap.isEmpty()) {
            array[i] = minHeap.poll();
            i++;
        }
        return array;
    }
}
