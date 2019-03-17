package BinarySearch;
import java.util.Arrays;
public class KClosestInSortedArray {
    public int[] kClosestVersion1(int[] array, int target, int k) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        int left = 0, right = array.length - k - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target - array[mid] > array[mid + k] - target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return Arrays.copyOfRange(array, left, k);
    }
}
