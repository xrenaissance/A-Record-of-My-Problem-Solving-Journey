package Subsets;
import java.util.List;
import java.util.ArrayList;

/**
 * @leetcode https://leetcode.com/problems/palindrome-partitioning/
 * @date 24/7/2019
 * @Time n !
 * @Space n
 */
public class PalindromePartioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> currLayer = new ArrayList<>();
        dfs(s, 0, currLayer, result);
        return result;
    }
    private void dfs(String s, int currLevel,
                     List<String> currLayer,
                     List<List<String>> result) {
        if (currLevel == s.length()) {
            result.add(new ArrayList<>(currLayer));
        }
        for (int i = currLevel; i < s.length(); i++) {
            if (isPalindrome(s, currLevel, i)) {
                currLayer.add(s.substring(currLevel, i + 1));
                dfs(s, i + 1, currLayer, result);
                currLayer.remove(currLayer.size() - 1);
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
