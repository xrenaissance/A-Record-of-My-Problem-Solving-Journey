package Subsets;

import java.util.*;

public class PermutationsWithDuplicates {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> currLayer = new ArrayList<>();
        permuteHelper(nums, 0, currLayer, result);
        return result;
    }
    private static void permuteHelper(int[] nums, int level,
                               List<Integer> currLayer,
                               List<List<Integer>> result) {
        if (level == nums.length) {
            result.add(new ArrayList<>(currLayer));
            return;
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = level; i < nums.length; i++) {
            if (visited.add(nums[i])) {
                currLayer.add(nums[i]);
                swap(nums, level, i);
                permuteHelper(nums, level + 1, currLayer, result);
                currLayer.remove(currLayer.size() - 1);
                swap(nums, level, i);
            }
        }
    }
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public static void main(String[] args) {
        int[] input1 = new int[] {1, 1, 2};
        System.out.println(PermutationsWithDuplicates.permuteUnique(input1).toString());
    }
}
