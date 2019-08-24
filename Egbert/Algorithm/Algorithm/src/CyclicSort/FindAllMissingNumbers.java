package CyclicSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * @Time N
 * @Space 1
 */
public class FindAllMissingNumbers {
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return missingNumbers;
        }
        int index = 0;
        while (index < nums.length) {
            while (nums[index] != nums[nums[index] - 1]) {
                swap(nums, index, nums[index] - 1);
            }
            index++;
        }
        for ( int i = 0; i < nums.length; i++) {
            if ( nums [i] != i + 1) {
                missingNumbers.add(i + 1);
            }
        }
        return missingNumbers;
    }
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public static void main(String[] args) {
        List<Integer> missing = FindAllMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);

        missing = FindAllMissingNumbers.findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);

        missing = FindAllMissingNumbers.findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);
    }
}
