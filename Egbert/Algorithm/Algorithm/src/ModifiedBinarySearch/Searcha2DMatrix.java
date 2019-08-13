package ModifiedBinarySearch;

/**
 * @leetcode https://leetcode.com/problems/search-a-2d-matrix/
 * @Time log n
 * @space 1
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            } else if (target > matrix[mid / cols][mid % cols]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
