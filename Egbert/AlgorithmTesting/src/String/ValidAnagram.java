package String;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/valid-anagram/
 * @date 29/7/2019
 * @Time m + n
 * @space 26
 */
public class ValidAnagram {
    public boolean isAnagramMap(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char currChar = t.charAt(i);
            if (map.get(currChar) == null || map.get(currChar) - 1 < 0) {
                return false;
            }
            map.put(currChar, map.get(currChar) - 1);
        }
        return true;
    }

    // Solution 2: array solution
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
            if (record[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
