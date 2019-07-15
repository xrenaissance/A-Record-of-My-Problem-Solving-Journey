package ModifiedBinarySearch;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5655120966582272
 * @leetcode https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * @date 15/7/2019
 * @Time Worst N, log N
 * @Space 1
 */
public class SearchRotatedWithDuplicate {
    public static int search(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] == key) {
                return mid;
            } else {
                if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                    start++;
                    end--;
                } else if (arr[mid] <= arr[end]) {
                    if (key > arr[mid] && key <= arr[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (key >= arr[start] && key < arr[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchRotatedWithDuplicate.search(new int[] { 3, 3, 7, 3 }, 7));
    }
}
