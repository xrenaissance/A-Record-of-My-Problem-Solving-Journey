package Hash;
import java.util.Set;
import java.util.HashSet;

/**
 * @leetcode https://leetcode.com/problems/longest-consecutive-sequence/
 * @Time N
 * @Space D number of dictinct numbers
 */
public class LongestConsecutiveSequence {


    // 2 * n Time
    // Space: D = number of distinct numbers
    public int longestConsecutiveSet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                int lower = num - 1;
                int upper = num + 1;
                while (set.contains(lower)) {
                    lower--;
                }
                while(set.contains(upper)) {
                    upper++;
                }
                longest = Math.max(longest, upper - lower - 1);
            }
        }
        return longest;
    }
}
