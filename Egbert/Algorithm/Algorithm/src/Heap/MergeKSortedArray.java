package Heap;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Egbert Li
 * @date 20/05/2019
 * Time: k log k
 * Space: O k
 */
public class MergeKSortedArray {
    // 6
    // 0 1 2 3 4 5
    public int[] merge(int[][] arrayOfArrays) {
        if (arrayOfArrays == null) {
            return null;
        }
        int length = 0;
        PriorityQueue<Entry> minHeap = new PriorityQueue<>(new EntryComparator());
        for (int i = 0; i < arrayOfArrays.length;i ++) {
            if (arrayOfArrays[i] != null && arrayOfArrays[i].length > 0) {
                length += arrayOfArrays[i].length;
                minHeap.offer(new Entry(i, 0, arrayOfArrays[i][0]));
            }
        }
        int[] result = new int[length];
        int currIndex = 0;
        while (!minHeap.isEmpty()) {
            Entry currEntry = minHeap.poll();
            result[currIndex++] = currEntry.value;
            if (currEntry.indexOfElem + 1 < arrayOfArrays[currEntry.indexOfArray].length) {
                currEntry.indexOfElem++;
                currEntry.value = arrayOfArrays[currEntry.indexOfArray][currEntry.indexOfElem];
                minHeap.offer(currEntry);
            }
        }
        return result;
    }
    public static class EntryComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry e1, Entry e2) {
            if (e1.value == e2.value) {
                return 0;
            }
            return e1.value < e2.value ? -1 : 1;
        }
    }
    public static class Entry {
        public int indexOfArray;
        public int indexOfElem;
        public int value;
        public Entry(int indexOfArray, int indexOfElem, int value) {
            this.indexOfArray = indexOfArray;
            this.indexOfElem = indexOfElem;
            this.value = value;
        }
    }
}
