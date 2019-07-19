package KWayMerge;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/4890648534581248
 * @date 20/7/2019
 * @Time k log M  M = total number of input arrays
 * @Space M
 */
public class KthSmallestInMSortedArrays {
    public static int findKthSmallest(List<Integer[]> lists, int k) {
        if (lists == null || lists.size() == 0) {
            return -1;
        }
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(
            (c1, c2) -> Integer.compare(c1.value, c2.value)
        );
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                minHeap.offer(new Cell(i, 0, lists.get(i)[0]));
            }
        }
        int kth = 0;
        int result = -1;
        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();
            kth++;
            result = cell.value;
            if (kth == k) {
                return result;
            }
            if (cell.indexOfElement + 1 < lists.get(cell.indexOfArray).length) {
                cell.indexOfElement++;
                cell.value = lists.get(cell.indexOfArray)[cell.indexOfElement];
                minHeap.offer(cell);
            }
        }
        return result;
    }
    public static class Cell {
        int indexOfArray;
        int indexOfElement;
        int value;
        public Cell(int indexOfArray, int indexOfElement, int value) {
            this.indexOfArray = indexOfArray;
            this.indexOfElement = indexOfElement;
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
