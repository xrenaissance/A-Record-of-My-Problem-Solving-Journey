package SlidingWindow;
import java.util.*;
public class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        int windowStart = 0;
        int longest = 0;
        // int the following loop we'll try to extend th erange [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            longest = Math.max(longest, windowEnd - windowStart + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
