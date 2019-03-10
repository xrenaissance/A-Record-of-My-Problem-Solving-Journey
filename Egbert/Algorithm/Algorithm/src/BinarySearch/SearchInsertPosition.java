package BinarySearch;

public class SearchInsertPosition {
    public static int searchInsertPosition(int[] input, int target) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int left = 0, right = input.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target <= input[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (input[left] <= target) {
            return left;
        } else if (input[right] < target) {
            return right + 1;
        } else {
            return right;
        }
    }
}
