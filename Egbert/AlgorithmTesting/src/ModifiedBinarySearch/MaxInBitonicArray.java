package ModifiedBinarySearch;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5941411948003328
 * @date 15/7/2019
 * @Time log N
 * @Space 1
 */
public class MaxInBitonicArray {

    public static int findMax(int[] arr) {
       if (arr == null || arr.length == 0) {
           return -1;
       }
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
       return arr[start];
    }

    // Genenic way
    public static int findMaxGenic(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
                return arr[mid];
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else if (arr[mid] < arr[mid - 1]) {
                end = mid - 1;
            }
        }
        if (arr[start] > arr[end]) {
            return arr[start];
        }
        return arr[end];
    }

    public static void main(String[] args) {
        System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
    }
}
