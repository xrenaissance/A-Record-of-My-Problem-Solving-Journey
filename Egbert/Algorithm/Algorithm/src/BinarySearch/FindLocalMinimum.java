package BinarySearch;

/**
 * @author Egbert Li
 * @Date 20/03/2019
 * There are 3 pattern, \/  /  and \
 * Time complexity is O(log n), space complexity is O(1)
 */
public class FindLocalMinimum {
    public int localMinimum(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[mid - 1] && array[mid] < array[mid + 1]) {
                return mid;
            } else if (array[mid] > array[mid - 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (array[right] < array[left]) {
            return right;
        }
        return left;
    }
}
