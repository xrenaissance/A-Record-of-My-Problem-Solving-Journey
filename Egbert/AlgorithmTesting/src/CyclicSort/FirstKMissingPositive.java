package CyclicSort;
import java.util.*;

/**
 * @link https://www.educative.io/courses/grokking-the-coding-interview/g286M2Gk3YY
 * @Time N + k
 * @space k
 */
public class FirstKMissingPositive {
    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return missingNumbers;
        }
        int index = 0;
        Set<Integer> existed = new HashSet<>();
        while (index < nums.length) {
            if (nums[index] > 0 && nums[index] <= nums.length &&
                nums[index] != nums[nums[index] - 1]) {
                swap(nums, index, nums[index] - 1);
            } else {
                index++;
            }
        }
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] != i + 1) {
                if (nums[i] > 0 && nums[i] <= nums.length + k) {
                    existed.add(nums[i]);
                }
                missingNumbers.add(i + 1);
                k--;
            }
        }
        index = 1;
        while (k > 0) {
            if (existed.add(nums.length + index)) {
                missingNumbers.add(nums.length + index);
                k--;
            }
            index++;
        }
        return missingNumbers;
    }
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public static void main(String[] args) {
        List<Integer> missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 2, 3, 4 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { -2, -3, 4 }, 2);
        System.out.println("Missing numbers: " + missingNumbers);
    }
}
