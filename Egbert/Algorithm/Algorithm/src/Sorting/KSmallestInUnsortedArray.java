package Sorting;
import java.util.Random;
import java.util.Arrays;

/**
 * @author Egbert Li
 * @date 5/4/2019
 * Time Complexity:(n + n/2 + n/4 + .. + 1) + O(k) + O(k log k)
 * ----> O(n) + (k log k)
 * Space complexity: log n
 */
public class KSmallestInUnsortedArray {
    public int[] kSmallest(int[] array, int k) {
        if (array == null || array.length == 0 || k == 0) {
            return new int[0];
        }
        quickSelect(array, 0, array.length - 1, k);
        int[] result = Arrays.copyOf(array, k); // O k
        Arrays.sort(result); // k log k
        return result;
    }
    private void quickSelect(int[] array, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(array, left, right);
        if (pivotIndex == k - 1) {
            return;
        } else if (pivotIndex < k - 1) {
            quickSelect(array, pivotIndex + 1, right, k);
        } else {
            quickSelect(array, left, pivotIndex - 1, k);
        }
    }
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
                end--;
            }
        }
        swap(array, start, right);
        return start;
    }
    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
