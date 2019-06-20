package SlidingWindow;
//Problem Statement
//        Given a string and a pattern, find out if the string contains any permutation of the pattern.
//
//        Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:
//
//        abc
//        acb
//        bac
//        bca
//        cab
//        cba
//        If a string has ‘n’ distinct characters it will have n!n! permutations.
//
//        Example 1:
//
//        Input: String="oidbcaf", Pattern="abc"
//        Output: true
//        Explanation: The string contains "bca" which is a permutation of the given pattern.
//        Example 2:
//
//        Input: String="odicf", Pattern="dc"
//        Output: false
//        Explanation: No permutation of the pattern is present in the given string as a substring.
//        Example 3:
//
//        Input: String="bcdxabcdy", Pattern="bcdyabcdx"
//        Output: true
//        Explanation: Both the string and the pattern are a permutation of each other.
//        Example 4:
//
//        Input: String="aaacb", Pattern="abc"
//        Output: true
//        Explanation: The string contains "acb" which is a permutation of the given pattern.
//        Input: String="aaacb", Pattern="abc"
//        Output: true
//        Explanation: The string contains "acb" which is a permutation of the given pattern.

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5401934796161024
 * @author Egbert Li
 * @date 19/06/2019
 * @Time O M + N
 * @Space O M
 */
public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        // our goal is to match all the characters from the 'charFrequencyMap' with the current window
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
                    matched++;
            }

            if (matched == charFrequencyMap.size())
                return true;

            if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--; // before putting the character back, decrement the matched count
                    // put the character back for matching
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println(StringPermutation.findPermutation("odicf", "dc"));
        System.out.println(StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println(StringPermutation.findPermutation("aaacb", "abc"));
    }
    }
}
