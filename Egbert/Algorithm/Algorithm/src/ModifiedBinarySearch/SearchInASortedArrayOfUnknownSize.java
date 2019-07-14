package ModifiedBinarySearch;

/**
 * @leetcode https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 * @date 13/7/2019
 * @Time log N
 * @Space 1
 */
public class SearchInASortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        int right = 1;
        while (target > reader.get(right)) {
            right *= 2;
        }
        int left = right / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > reader.get(mid)) {
                left = mid + 1;
            } else if (target < reader.get(mid)) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
