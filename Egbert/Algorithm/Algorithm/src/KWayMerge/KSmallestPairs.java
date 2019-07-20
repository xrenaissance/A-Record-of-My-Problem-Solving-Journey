package KWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;
/**
 * @leetcode https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * @date 20/7/2019
 * @Time k log k
 * @Space k + n * m
 */
public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(
                (c1, c2) -> Integer.compare(c1.sum, c2.sum)
        );
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        minHeap.offer(new Cell(0, 0, nums1[0] + nums2[0]));
        visited[0][0] = true;
        while (!minHeap.isEmpty() && k > 0) {
            Cell cell = minHeap.poll();
            result.add(Arrays.asList(nums1[cell.row], nums2[cell.col]));
            k--;
            if (k == 0) {
                break;
            }
            if (isValid(nums1, nums2, cell.row + 1, cell.col, visited)) {
                minHeap.offer(new Cell(cell.row + 1, cell.col,
                        nums1[cell.row + 1] + nums2[cell.col]));
                visited[cell.row + 1][cell.col] = true;
            }
            if (isValid(nums1, nums2, cell.row, cell.col + 1, visited)) {
                minHeap.offer(new Cell(cell.row, cell.col + 1,
                        nums1[cell.row] + nums2[cell.col + 1]));
                visited[cell.row][cell.col + 1] = true;
            }
        }
        return result;
    }
    private static boolean isValid(int[] nums1, int[] nums2, int row, int col,
                                   boolean[][] visited) {
        return row < nums1.length && col < nums2.length && !visited[row][col];
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
}
