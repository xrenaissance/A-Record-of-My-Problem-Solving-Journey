package BinarySearch;
/**
 * @author Egbert Li
 * @Date 20/03/2019
 * Check which interval that middle point locates, then check which searching
 * interval that target locates
 * The Time Complexity is O(log n), Space Complexity is O(1)
 */
public class SearchInShiftedSortedArrayI {
    public int search(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[left]) { // if target is in left half
                if (target >= array[left] && target <= array[mid]) { // if target is in sorted interval
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (target >= array[mid] && target <= array[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        // Check which one is target
        if (target == array[left]) {
            return left;
        } else if (target == array[right]) {
            return right;
        } else {
            return -1;
        }
    }
}
