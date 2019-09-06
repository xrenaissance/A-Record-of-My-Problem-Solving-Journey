package ModifiedBinarySearch;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/6447997434986496
 * @author Egbert Li
 * @date 13/07/2019
 * @Time log N
 * @Space 1
 */
public class CeilingOfANumber {
    // smallest number that >= key
    public static int searchCeilingOfANumber(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int length = arr.length;
        if (arr[length - 1] < key) {
            return -1;
        }
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > key) {
                end = mid - 1;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
        // we are not able to find the element in the given array, so the next big number will be arr[start]
        return start;
    }

    public static void main(String[] args) {
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}
