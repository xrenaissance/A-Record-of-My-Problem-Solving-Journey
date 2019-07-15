package ModifiedBinarySearch;

/**
 * @leetcode https://leetcode.com/problems/search-in-rotated-sorted-array/
 * @date 15/7/2019
 * @Time log N
 * @Space 1
 */
public class SearchRotatedArray {
    public static int search(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key == arr[mid]) {
                return mid;
            }
            if (arr[mid] < arr[end]) {
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
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(SearchRotatedArray.search(
                new int[] { 10, 15, 1, 3, 8 }, 15));
        System.out.println(SearchRotatedArray.search(
                new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
    }
}
