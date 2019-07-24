package Subsets;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * @leetcode https://leetcode.com/problems/subsets-ii/
 * @date 21/7/2019
 * @Time 2 ^ N
 * @Space n
 */
public class SubsetWithDuplicates {
    // Solution 1: BFS 2 ^ N , Space 2 ^ N
    public static List<List<Integer>> findSubsetsBFS(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return subsets;
        }
        Arrays.sort(nums);
        subsets.add(new ArrayList<Integer>());
        int endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = subsets.size();
            int start = 0;
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = endIndex + 1;
            }
            endIndex = size - 1;
            for (int j = start; j < size; j++) {
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }
    // Solution 2: DFS
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return subsets;
        }
        List<Integer> currLayer = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(nums, currLayer, 0, subsets);
        return subsets;
    }
    private static void findSubsets(int[] nums, List<Integer> curLayer,
                                    int level, List<List<Integer>> subsets) {
        if (level == nums.length) {
            subsets.add(new ArrayList<>(curLayer));
            return;
        }
        // add number in current level
        curLayer.add(nums[level]);
        findSubsets(nums, curLayer, level + 1, subsets);
        curLayer.remove(curLayer.size() - 1);

        while (level + 1 < nums.length && nums[level] == nums[level + 1]) {
            level++;
        }
        findSubsets(nums, curLayer, level + 1, subsets);
    }
    // Solution 3: Using general dfs pattern
    public List<List<Integer>> subsetsWithDupGDFS(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> currLayer = new ArrayList<>();
        Arrays.sort(nums);
        gdfs(nums, 0, currLayer, result);
        return result;
    }
    private void gdfs(int[] nums, int currLevel, List<Integer> currLayer,
                      List<List<Integer>> result) {
        result.add(new ArrayList<>(currLayer));
        for (int i = currLevel; i < nums.length; i++) {
            if (i > currLevel && nums[i] == nums[i - 1]) {
                continue;
            }
            currLayer.add(nums[i]);
            gdfs(nums, i + 1, currLayer, result);
            currLayer.remove(currLayer.size() - 1);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
