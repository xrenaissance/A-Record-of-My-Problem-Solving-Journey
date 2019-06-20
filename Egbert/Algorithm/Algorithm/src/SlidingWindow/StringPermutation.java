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
        if (str == null || pattern == null) {
            return false;
        }
        Map<Character, Integer> charFreqMap = createCharFreqMap(pattern);
        int windowStart = 0;
        int matched = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFreqMap.containsKey(rightChar)) {
                charFreqMap.put(rightChar, charFreqMap.get(rightChar) - 1);
                if (charFreqMap.get(rightChar) == 0) {
                    matched++;
                }
            }
            if (matched == charFreqMap.size()) {
                return true;
            }
            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart);
                if (charFreqMap.containsKey(leftChar)) {
                    if (charFreqMap.get(leftChar) == 0) {
                        matched--;
                    }
                }
                windowStart++;
            }
        }
        return false;
    }
    public static Map<Character, Integer> createCharFreqMap(String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return new HashMap<>();
        }
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char curLetter = pattern.charAt(i);
            charFreqMap.put(curLetter,
                    charFreqMap.getOrDefault(curLetter, 0 ) + 1);
        }
        return charFreqMap;
    }
    public static void main(String[] args) {
        System.out.println(StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println(StringPermutation.findPermutation("odicf", "dc"));
        System.out.println(StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println(StringPermutation.findPermutation("aaacb", "abc"));
    }
}
