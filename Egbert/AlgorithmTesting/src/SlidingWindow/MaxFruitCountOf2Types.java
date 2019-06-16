package SlidingWindow;

import java.util.*;

public class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int windowStart = 0;
        int max = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char rightChar = arr[windowEnd];
            charFrequencyMap.put(rightChar,
                    charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            while (charFrequencyMap.size() > 2) {
                char leftChar = arr[windowStart];
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
            max = Math.max(max, windowEnd - windowStart + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
