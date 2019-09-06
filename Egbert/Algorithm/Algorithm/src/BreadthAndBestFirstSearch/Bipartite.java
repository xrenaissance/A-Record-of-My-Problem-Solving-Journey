package ModifiedBinarySearch;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/51148377072599041
 * @author Egbert Li
 * @date 15/7/2019
 * @Time log n
 * @Space 1
 */
public class SearchBitonicArray {
    public static int search(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int maxIndex = searchMaxIndex(arr);
        int index = binarySearch(arr, key, true, 0, maxIndex);
        if (index != -1) {
            return index;
        }
        return binarySearch(arr, key, false, maxIndex + 1, end);
    }
    private static int searchMaxIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    private static int binarySearch(int[] arr, int key, boolean isAscending,
                                    int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (isAscending) {
                if (key < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (key < arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
}
