package KWayMerge;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Time 20/7/2019
 * @leetcode https://leetcode.com/problems/smallest-range/
 * @Time N log M  N = total number of elements M = M inputs arrays
 * @Space M for heap
 */
public class SmallestRange {
    public static int[] findSmallestRange(List<Integer[]> lists) {
        if (lists == null || lists.size() == 0) {
            return new int[] { -1, -1 };
        }
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(
                (c1, c2) -> Integer.compare(c1.value, c2.value)
        );
        int currMax = Integer.MIN_VALUE;
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            currMax = Math.max(currMax, lists.get(i)[0]);
            minHeap.offer(new Cell(i, 0, lists.get(i)[0]));
        }
        while (minHeap.size() == lists.size()) {
            Cell cell = minHeap.poll();
            if (rangeEnd - rangeStart > currMax - cell.value) {
                rangeStart = cell.value;
                rangeEnd = currMax;
            }
            cell.indexOfElem++;
            if (isValid(lists, cell.indexOfArray, cell.indexOfElem)){
                cell.value = lists.get(cell.indexOfArray)[cell.indexOfElem];
                currMax = Math.max(currMax, cell.value);
                minHeap.offer(cell);
            }
        }
        return new int[] {rangeStart, rangeEnd};
    }
    private static boolean isValid(List<Integer[]> lists, int row, int col) {
        return row < lists.size() && col < lists.get(row).length;
    }
    public static class Cell {
        int indexOfArray;
        int indexOfElem;
        int value;
        public Cell(int indexOfArray, int indexOfElem, int value) {
            this.indexOfArray = indexOfArray;
            this.indexOfElem = indexOfElem;
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 1, 5, 8 };
        Integer[] l2 = new Integer[] { 4, 12 };
        Integer[] l3 = new Integer[] { 7, 8, 10 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }
}
