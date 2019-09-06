package BinarySearch;
import java.util.Arrays;

/**
 * @author  Egbert
 * @Date 18/03/2019
 */

public class KClosestInSortedArray {


    // The time complexity is O(log n) + k, space complexity is O(k)
    public int[] kClosestVersion(int[] array, int target, int k) {
        if (array == null || array.length == 0 || k == 0) {
            return new int[0];
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target <= array[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (right >= array.length || left >= 0 && Math.abs(target - array[left]) <= Math.abs(target - array[right])) {
                result[i] = array[left];
                left--;
            } else {
                result[i] = array[right];
                right++;
            }
        }
        return result;
    }
}
