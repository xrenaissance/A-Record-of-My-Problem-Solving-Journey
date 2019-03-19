package BinarySearch;

/**
 * @author  Egbert Li
 * @Date 20/March/2019
 * left may not exist, always compare to right
 * Time complexity is O(log n), Space complexity is O(1)
 */
public class ShiftPosition {
    public int shiftPosition(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (array[left] < array[right]) {
            return left;
        }
        return right;
    }
}
