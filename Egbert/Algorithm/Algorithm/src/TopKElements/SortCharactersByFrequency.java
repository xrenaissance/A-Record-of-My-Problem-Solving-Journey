package TopKElements;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/sort-characters-by-frequency/
 * @date 16/7/2019
 * @Time N + N log N
 * @Space N + N -> N
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // N
        Map<Character, Integer> charFreqMap = getCharFreqMap(s);
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(charFreqMap.size(),
                (a, b) -> a.getValue() == b.getValue() ?
                        Character.compare(a.getKey(), b.getKey()) :
                        b.getValue().compareTo(a.getValue())
        );
        // N log N
        for (Map.Entry<Character, Integer> entry : charFreqMap.entrySet()) {
            maxHeap.offer(entry);
        }
        StringBuilder result = new StringBuilder();
        // N log N
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char currLetter = entry.getKey();
            int currFreq = entry.getValue();
            for (int i = 0; i < currFreq; i++) {
                result.append(currLetter);
            }
        }
        return result.toString();
    }
    private Map<Character, Integer> getCharFreqMap(String s) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currLetter = s.charAt(i);
            charFreqMap.put(currLetter, charFreqMap.getOrDefault(currLetter, 0) + 1);
        }
        return charFreqMap;
    }
}
