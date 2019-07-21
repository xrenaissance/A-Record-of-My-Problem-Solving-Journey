package Subsets;
import java.util.List;
import java.util.ArrayList;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5670249378611200
 * @leetcode https://leetcode.com/problems/subsets/
 * @date 21/7/2019
 * @Time BFS,DFS 2 ^ n   n is the number of distinct numbers
 * @Space DFS: N  BFS: 2 ^ n
 */
public class Subsets {
    // Solution 1 BFS
    public static List<List<Integer>> findSubsetsBFS(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null) {
            return subsets;
        }
        subsets.add(new ArrayList<Integer>());
        for (int num : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(num);
                subsets.add(set);
            }
        }
        return subsets;
    }
    // Solution 2: DFS
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null) {
            return subsets;
        }
        List<Integer> currLayer = new ArrayList<>();
        findSubsets(nums, currLayer, 0, subsets);
        return subsets;
    }
    private static void findSubsets(int[] nums, List<Integer> currLayer,
                                    int level, List<List<Integer>> subsets) {
        if (level == nums.length) {
            subsets.add(new ArrayList<>(currLayer));
            return;
        }
        // add element in current layer
        currLayer.add(nums[level]);
        findSubsets(nums, currLayer, level + 1, subsets);
        currLayer.remove(currLayer.size() - 1);

        // don't add element in current layer
        findSubsets(nums, currLayer, level + 1, subsets);
    }
    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
