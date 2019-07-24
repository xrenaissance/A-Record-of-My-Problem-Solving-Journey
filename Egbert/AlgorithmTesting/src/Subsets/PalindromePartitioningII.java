package Subsets;
import java.util.List;
import java.util.ArrayList;

/**
 * @leetcode https://leetcode.com/problems/palindrome-partitioning-ii/
 * @date 24/7/2019
 * @Time n!
 * @Space n
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        int[] min = new int[1];
        if (s == null || s.length() <= 1) {
            return min[0];
        }
        min[0] = Integer.MAX_VALUE;
        int[] total = new int[1];
        dfs(s, 0, total, min);
        return min[0];
    }
    private void dfs(String s, int currLevel,
                     int[] total,
                     int[] min) {
        if (currLevel == s.length()) {
            min[0] = Math.min(min[0], total[0] - 1);
        }
        for (int i = currLevel; i < s.length(); i++) {
            if (isPalindrome(s, currLevel, i)) {
                total[0]++;
                dfs(s, i + 1, total, min);
                total[0]--;
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
