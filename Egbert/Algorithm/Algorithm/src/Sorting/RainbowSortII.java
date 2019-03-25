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

    // Solution 2, using counting sort
    public int[] rainbowSortII(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        rainbowSortII(array, 4);
        return array;
    }
    private void rainbowSortII(int[] array, int k) {
        int[] count = new int[k];
        for (int color : array) {
            count[color]++;
        }
        int index = 0;
        for (int color = 0; color < k; color++) {
            for (int t = 0; t < count[color]; t++) {
                array[index] = color;
                index++;
            }
        }
    }
}
