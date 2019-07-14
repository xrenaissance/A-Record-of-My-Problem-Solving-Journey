package TagedByCompany.GoldManSachs;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/first-unique-character-in-a-string/
 * @Date 13/7/2019
 * @Time O N
 */
public class FirstUniqueCharacterInAString {
    // Second Solution
    public int firstUniqCharArray(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] charFreqTable = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charFreqTable[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charFreqTable[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    // My initial solution
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int windowStart = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);
        }
        while (windowStart <= s.length() - 1) {
            if (charFreqMap.get(s.charAt(windowStart)) > 1) {
                windowStart++;
            } else {
                return windowStart;
            }
        }
        return -1;
    }
}
