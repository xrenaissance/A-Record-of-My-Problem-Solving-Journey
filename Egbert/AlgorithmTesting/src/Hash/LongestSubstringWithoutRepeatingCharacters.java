package Hash;
import java.util.Map;
import java.util.HashMap;
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0;
        int longest = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            while (map.get(rightChar) > 1) {
                char leftChar = s.charAt(windowStart);
                map.put(leftChar, map.get(leftChar) - 1);
                windowStart++;
            }
            longest = Math.max(longest, windowEnd - windowStart + 1);
        }
        return longest;
    }
}
