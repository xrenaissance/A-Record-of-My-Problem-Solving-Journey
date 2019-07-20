package KWayMerge;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/6521584850305024
 * @date 20/7/2019
 * @Time k log k
 * @Space n * m + k
 */
public class LargestPairs {
    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        PriorityQueue<Cell> maxHeap = new PriorityQueue<>(
            (c1, c2) -> c2.sum - c1.sum
        );
        maxHeap.offer(new Cell(0, 0, nums1[0] + nums2[0]));
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        visited[0][0] = true;
        while (!maxHeap.isEmpty() && k > 0) {
            Cell cell = maxHeap.poll();
            result.add(new int[] {nums1[cell.row], nums2[cell.col]});
            k--;
            if (k == 0) {
                break;
            }
            if (isValid(nums1, nums2, cell.row + 1, cell.col) &&
                !visited[cell.row + 1][cell.col]) {
                maxHeap.offer(new Cell(cell.row + 1, cell.col,
                        nums1[cell.row + 1] + nums2[cell.col]));
                visited[cell.row + 1][cell.col] = true;
            }
            if (isValid(nums1, nums2, cell.row, cell.col + 1) &&
                    !visited[cell.row][cell.col + 1]) {
                maxHeap.offer(new Cell(cell.row, cell.col + 1,
                        nums1[cell.row] + nums2[cell.col + 1]));
                visited[cell.row][cell.col + 1] = true;
            }
        }
        return result;
    }
    private static boolean isValid(int[] nums1, int[] nums2, int row, int col) {
        return row < nums1.length && col < nums2.length;
    }
    public static class Cell {
        int row;
        int col;
        int sum;
        public Cell(int row, int col, int sum) {
            this.row = row;
            this.col = col;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        int[] l1 = new int[] { 9, 8, 2 };
        int[] l2 = new int[] { 6, 3, 1 };
        List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 3);
        System.out.print("Pairs with largest sum are: ");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
    }
}
