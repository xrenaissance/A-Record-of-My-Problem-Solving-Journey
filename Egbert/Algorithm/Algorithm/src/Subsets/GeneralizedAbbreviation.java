package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @leetcode https://leetcode.com/problems/generalized-abbreviation/
 * @date 27/7/2019
 * @Time 2 ^ n  n levels, 2 states, abbreviate it or not
 * @Space n the height
 */
public class GeneralizedAbbreviation {
    public static List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        if (word == null) {
            return result;
        }
        StringBuilder currLayer = new StringBuilder();
        dfs(word, currLayer, 0, 0, result);
        return result;
    }
    private static void dfs(String word, StringBuilder currLayer,
                     int level, int numOfAbb,
                     List<String> result) {
        if (level == word.length()) {
            if (numOfAbb > 0) {
                currLayer.append(numOfAbb);
            }
            result.add(currLayer.toString());
            return;
        }

        // add letter in current level --> not abbreviate it
        int startLength = currLayer.length();
        if (numOfAbb > 0) {
            currLayer.append(numOfAbb);
        }
        currLayer.append(word.charAt(level));
        dfs(word, currLayer, level + 1, 0, result);
        currLayer.setLength(startLength);

        // abbreviate it
        dfs(word, currLayer, level + 1, numOfAbb + 1, result);
        currLayer.setLength(startLength);
    }
    public static void main(String[] args) {
        List<Character> test = Arrays.asList('a', '1', 'b');
        String str = test.toString();
        System.out.println(GeneralizedAbbreviation.
                generateAbbreviations("aaaaaaaaabbbbbbbcccccccc").size());
        System.out.println(GeneralizedAbbreviation.
                generateAbbreviations("abcd").size());
        System.out.println(GeneralizedAbbreviation.
                generateAbbreviations("abcdef").size());
        System.out.println(GeneralizedAbbreviation.
                generateAbbreviations("aabcd").size());
    }
}
