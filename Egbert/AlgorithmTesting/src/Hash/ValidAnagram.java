package Hash;

/**
 * @leetcode https://leetcode.com/problems/valid-anagram/
 * @Time m + n
 * @Space 128 which can handle unicode characters
 */
public class ValidAnagram {
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
        int[] charFreq = new int[128];
        for (int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--charFreq[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
