package Sorting;
import java.util.Random;

/**
 * @author Egbert
 * @date 8/4/2019 review again
 * @aim clean code
 * Time complexity Worst case: every time pivotValue is largest or smalllest
 * so Worst: O(n + n - 1 + n -2 + ..+1) ----> O(n ^ 2)
 * Average: log n layers, each time need O(n) operations --> O(n log n)
 * Space complexity O(log n) * 1
 */
public class QuickSortArray {
    public int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }
    // overload the method
    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }
    // randomly get the pivot Index and sort as well
    private int partition(int[] array, int left, int right) {
        Random random = new Random();
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(array, randomIndex, right);
        int start = left;
        int end = right - 1;
        while (start <= end) {
            if (array[start] <= array[right]) {
                start++;
            } else {
                swap(array, start, end);
                end --;
            }
        }
        swap(array, start, right);
        return start;
    }
    // swap two element
    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
