package TopKElements;

/**
 * @date 17/7/2019
 * @Time n ^ 2
 * @Space 1
 */
public class FlipSort {
    public static void flipSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int right = arr.length - 1;
        while (right >= 0) {
            int largestIndex = largest(arr, right);
            swap(arr, 0, largestIndex);
            FlipSort.flip(arr, right);
            right--;
        }
    }
    private static int largest(int[] arr, int right) {
        int largestIndex = 0;
        int i = 0;
        while (i <= right) {
            if (arr[i] > arr[largestIndex]) {
                largestIndex = i;
            }
            i++;
        }
        return largestIndex;
    }
    public static void flip(int[] arr, int index) {
        int left = 0;
        while (left < index) {
            swap(arr, left++, index--);
        }
    }
    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static void main(String[] args) {
        int[] input1 = new int[] {3, 0, 4, 1};
        int[] input2 = new int[] {-1, 1, -9, 4, 12};
        int[] input3 = new int[] {1, 1, 1, 1};
        FlipSort.flipSort(input1);
        FlipSort.flipSort(input2);
        FlipSort.flipSort(input3);
        for(int i = 0; i < input1.length; i++) System.out.print(input1[i] + " ");
        System.out.println();
        for(int i = 0; i < input2.length; i++) System.out.print(input2[i] + " ");
        System.out.println();
        for(int i = 0; i < input3.length; i++) System.out.print(input3[i] + " ");
    }
}
