package ModifiedBinarySearch;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/4717486123515904
 * @date 15/07/2019
 * @Time log N
 * @Space 1
 */
public class MinimumDifference {
    public static int searchMinDiffElement(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (key > arr[mid]) {
                start = mid;
            } else if (key < arr[mid]) {
                end = mid;
            } else {
                return mid;
            }
        }
        if (Math.abs(key - arr[end]) < Math.abs(key - arr[start])) {
            return arr[end];
        }
        return arr[start];
    }

    public static void main(String[] args) {
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}
