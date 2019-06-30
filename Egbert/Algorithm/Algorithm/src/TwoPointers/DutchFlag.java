package TwoPointers;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5784530449334272
 * @author Egbert li
 * @date 1/07/2019
 * @Time O N
 * @Space O 1
 */
public class DutchFlag {
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int zero = 0;
        int one = 0;
        int two = arr.length - 1;
        while (one <= two) {
            if (arr[one] == 0) {
                swap(arr, zero++, one++);
            } else if (arr[one] == 1) {
                one++;
            } else {
                swap(arr, one, two--);
            }
        }
    }
    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        DutchFlag.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        DutchFlag.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
