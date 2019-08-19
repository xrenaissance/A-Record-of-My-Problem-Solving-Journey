package MergeIntervals;
import java.util.*;
/**
 * @leetcode https://leetcode.com/problems/interval-list-intersections/
 * @Time O N
 * @Space N
 */
public class IntervalListIntersections {
    public int[][] intervalIntersectionClean(int[][] arr1, int[][] arr2) {
        List<int[]> result = new ArrayList<>();
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
            return new int[0][];
        }
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            int start = Math.max(arr1[i][0], arr2[j][0]);
            int end = Math.min(arr1[i][1], arr2[j][1]);
            if (end >= start) {
                result.add(new int[]{start, end});
            }
            if (end == arr1[i][1]) {
                i++;
            }
            if (end == arr2[j][1]) {
                j++;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    // my initial solution
    public int[][] intervalIntersection(int[][] arr1, int[][] arr2) {
        List<int[]> result = new ArrayList<>();
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
            return new int[0][];
        }
        int i = 0;
        int j = 0;
        int start = 0;
        int end = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i][0] > arr2[j][1]) {
                j++;
            } else if (arr2[j][0] > arr1[i][1]) {
                i++;
            } else if (arr1[i][0] <= arr2[j][1] || arr2[j][0] <= arr1[i][1]) {
                start = Math.max(arr1[i][0], arr2[j][0]);
                end = Math.min(arr1[i][1], arr2[j][1]);
                if (arr1[i][1] > arr2[j][1]) {
                    j++;
                } else if (arr2[j][1] > arr1[i][1]) {
                    i++;
                } else {
                    i++;
                    j++;
                }
                result.add(new int[]{start, end});
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
