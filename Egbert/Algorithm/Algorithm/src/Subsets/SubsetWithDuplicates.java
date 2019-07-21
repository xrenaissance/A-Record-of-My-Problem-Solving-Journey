package Subsets;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class SubsetWithDuplicates {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return subsets;
        }
        Arrays.sort(nums);
        subsets.add(new ArrayList<Integer>());
        int prevSize = 1;
        int i = 0;
        while (i < nums.length) {
            int n = subsets.size();
            int start = 0;
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = n - prevSize;
            }
            for (; start < n; start++) {
                List<Integer> set = new ArrayList<>(subsets.get(start));
                set.add(nums[i]);
                subsets.add(set);
            }
            prevSize = subsets.size() - n;
            i++;
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
