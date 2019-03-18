package BinarySearch;

/**
 * @author Egbert Li
 * @Date 18/03/2019 Third Time
 * Time Complexity: O(log m * n), space complexity O(1)
 */
public class SearchInSortedMatrixI {
    public int[] search(int[][] matrix, int target) {
        int[] result = new int[]{-1, -1};
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = row * col - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == matrix[mid / col][mid % col]) {
                result[0] = mid / col;
                result[1] = mid % col;
                return result;
            } else if (target < matrix[mid / col][mid % col]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
