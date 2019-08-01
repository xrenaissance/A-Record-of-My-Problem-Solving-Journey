package StringI;

/**
 * @leetcode https://leetcode.com/problems/find-the-difference/
 * @Time m + n
 * @Space 1
 */
public class FindtheDifference {
    // Solution 1: missing number bit xor
    public char findTheDifferenceBit(String s, String t) {
        char result = t.charAt(0);
        for (int i = 1; i < t.length(); i++) {
            result ^= t.charAt(i);
            result ^= s.charAt(i - 1);
        }
        return result;
    }
    // Solution2: Array
    public char findTheDifference(String s, String t) {
        int[] charFreq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charFreq[ch - 'a']++;
        }
        char result = 'a';
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (--charFreq[ch - 'a'] < 0) {
                result = ch;
                break;
            }
        }
        return result;
    }
}
