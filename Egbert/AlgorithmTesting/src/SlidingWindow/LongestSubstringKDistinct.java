package SlidingWindow;
import java.util.*;

/**
 * @author Egbert Li
 * @date 15/06/2019
 * @Time O (n + n)
 * @space O(k + 1) at most
 */
public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int windowStart = 0;
        int longest = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                   charFrequencyMap.remove(leftChar);
                }
                windowStart++;
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
