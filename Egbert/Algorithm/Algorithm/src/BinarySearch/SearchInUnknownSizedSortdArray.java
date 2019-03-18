package BinarySearch;
import java.util.Dictionary;
/**
 * @author Egbert Li
 * @Date 19/03/2019 * Coding with move 2 times each step and 10 times each step *
 */
public class SearchInUnknownSizedSortdArray {
    public int searchTwoTimes(Dictionary dict, int target) {
        if (dict == null) {
            return -1;
        }
        int left = 0, right = 1;

        // Find the lower bound and upper bound
        while (dict.get(right) != null && target > dict.get(right)) {
            if (target == dict.get(right)) {
                return right;
            }
            left = right;
            right *= 2;
        }
        // Classic binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dict.get(mid) == null || target < dict.get(mid)) {
                right = mid - 1;
            } else if (target > dict.get(mid)) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int searchTenTimes(Dictionary dict, int target) {
        int[] result = new int[]{-1, -1};
        int left = 0, right = 1;
        while (dict.get(right) != null && target > dict.get(right)) {
            left = right;
            right *= 10;
        }

        // Classical Binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dict.get(mid) == null || target < dict.get(mid)) {
                right = mid - 1;
            } else if (target > dict.get(mid)) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
