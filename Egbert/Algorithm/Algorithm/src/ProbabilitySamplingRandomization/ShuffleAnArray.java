package ProbabilitySamplingRandomization;
import java.util.Random;

/**
 * @author Egbert Li
 * @date 5/06/2019
 * @Time O n
 * @Space O n
 */
public class ShuffleAnArray {
    private int[] nums;
    private Random random;
    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        random  = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        int[] clonedNums = nums.clone();
        for (int j = 1; j < clonedNums.length; j++) {
            int index = random.nextInt(j + 1);
            swap(clonedNums, index, j);
        }
        return clonedNums;
    }
    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
