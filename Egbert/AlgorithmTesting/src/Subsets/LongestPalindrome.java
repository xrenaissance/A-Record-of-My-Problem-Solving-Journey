package Subsets;
import java.util.Set;
import java.util.HashSet;

/**
 * @leetcode https://leetcode.com/problems/longest-palindrome/
 * @date 29/7/2019
 * @Time N
 * @Space N
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                set.remove(s.charAt(i));
            }
        }
        if (set.size() >= 1) {
            return s.length() - set.size() + 1;
        }
        return s.length() - set.size();
    }
}
