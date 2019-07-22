package Subsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode https://leetcode.com/problems/permutations/
 * @date 22/7/2019
 * @Time n!
 * @Spac n
 */
public class Permutations {
    // BFS
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        result.add(new ArrayList<Integer>());
//        for (int i = 0; i < nums.length; i++) {
//            int size = result.size();
//            for (int j = 0; j < size) {
//
//            }
//        }
        return result;
    }
    // Solution 2: DFS
    public static List<List<Integer>> findPermutationsDFS(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> currLayer = new ArrayList<>();
        permutations(nums, currLayer, 0, result);
        return result;
    }
    private static void permutations(int[] nums, List<Integer> currLayer,
                                     int level, List<List<Integer>> result) {
        if (level == nums.length) {
            result.add(new ArrayList<>(currLayer));
            System.out.println("---------------------------");
            return;
        }
        for (int i = level; i < nums.length; i++) {
            swap(nums, i, level);
            currLayer.add(nums[level]);
            permutations(nums, currLayer, level + 1, result);
            System.out.println("remove ---- ");
            currLayer.remove(currLayer.size() - 1);
            swap(nums, i, level);
        }
    }
    private static void swap(int[] nums, int left,int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutationsDFS(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
