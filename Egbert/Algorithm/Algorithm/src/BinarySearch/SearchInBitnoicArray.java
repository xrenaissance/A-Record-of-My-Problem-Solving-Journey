package BinarySearch;

/**
 * @author Egbert Li
 * @Date 22/03/2019
 * Time Complexity: Log N, Space Complexity: O(1)
 */
public class SearchInBitnoicArray {
    public int search(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        // Log n
        int maxIndex = findMax(array);
        if (target == array[maxIndex]) {
            return maxIndex;
        } else if (target > array[maxIndex]) {
            return -1;
        } else {
            // log(N/2)
            int leftResult = ascendingBinarySearch(array, 0, maxIndex, target);
            if (leftResult != -1) {
                return leftResult;
            } else {
                // log (N/2)
                return decendingBinarySearch(array, maxIndex, array.length - 1, target);
            }
        }
    }

    private int ascendingBinarySearch (int[] array, int left,
                                       int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (target > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int decendingBinarySearch(int[] array, int left,
                                      int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == array[mid]) {
                return mid;
            } else if (target > array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return - 1;
    }

    // Find the index of maximum number in the array
    private int findMax(int[] array) {
        int left = 0, right = array.length - 1, target = array[0];
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
                return mid;
            } else if (array[mid] > array[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[right] > array[left]) {
            return right;
        }
        return left;
    }
}
