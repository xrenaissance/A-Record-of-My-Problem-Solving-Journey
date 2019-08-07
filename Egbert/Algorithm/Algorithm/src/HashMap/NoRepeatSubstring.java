package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @leetcode https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @author Egbert Li
 * @date 16/06/2019
 * @Time O(N)
 * @Space O(N) The worst case is 26,26 letters
 */
public class NoRepeatSubstring {
    public static int findLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int windowStart = 0;
        int longest = 0;
        Map<Character, Integer> charIndex = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charIndex.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, charIndex.get(rightChar) + 1);
            }
            charIndex.put(rightChar, windowEnd);
            longest = Math.max(longest, windowEnd - windowStart + 1);
        }
        return longest;
   }
    public static int findLengthSet(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int windowStart = 0;
        int windowEnd = 0;
        int longest = 0;
        Set<Character> charSet = new HashSet<>();
        while (windowEnd < str.length()) {
            char rightChar = str.charAt(windowEnd);
            if (charSet.add(rightChar)) {
                longest = Math.max(longest, windowEnd - windowStart + 1);
                windowEnd++;
            } else {
                char leftChar = str.charAt(windowStart);
                charSet.remove(leftChar);
                windowStart++;
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + SlidingWindow.NoRepeatSubstring.findLengthSet("aabccbb"));
        System.out.println("Length of the longest substring: " + SlidingWindow.NoRepeatSubstring.findLengthSet("abbbb"));
        System.out.println("Length of the longest substring: " + SlidingWindow.NoRepeatSubstring.findLengthSet("abccde"));
    }
}
