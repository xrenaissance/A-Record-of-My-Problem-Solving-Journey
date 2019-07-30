package Subsets;
import java.util.Set;
import java.util.HashSet;

/**
 * @leetcode https://leetcode.com/problems/palindrome-permutation/
 * @date 30/7/2019
 * @Time N
 * @Space N
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                set.remove(s.charAt(i));
            }
        }
        return set.size() == 0 || set.size() == 1;
    }
}
