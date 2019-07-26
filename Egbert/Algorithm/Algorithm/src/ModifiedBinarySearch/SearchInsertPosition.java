package ModifiedBinarySearch;

/**
 * @leetcode https://leetcode.com/problems/search-insert-position/
 * @date 26/7/2019;
 * @Time log N
 * @Space 1
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right < 0) {
            return 0;
        }
        return left;
    }
}
