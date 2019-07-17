package TopKElements;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5724822843686912jjj
 * @leetcode https://leetcode.com/problems/reorganize-string/
 * @date 18/7/2019
 * @Time nlogn + n
 * @Space N
 */
public class RearrangeString {
    public static String rearrangeString(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Map<Character, Integer> charFreqMap = createCharFreq(str);
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue()
        );
        // add all characters to the maxHeap
        maxHeap.addAll(charFreqMap.entrySet());
        Map.Entry<Character, Integer> prevEntry = null;
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currEntry = maxHeap.poll();
            System.out.println(" ------    " + currEntry.getKey());
            // add the previous entry back in the heap if its frequency is greater than zero
            if (prevEntry != null && prevEntry.getValue() > 0) {
                maxHeap.offer(prevEntry);
            }
            // append the current character to the result
            result.append(currEntry.getKey());
            currEntry.setValue(currEntry.getValue() - 1);
            prevEntry = currEntry;
        }
        return result.length() == str.length() ? result.toString() : "";
    }
    private static Map<Character, Integer> createCharFreq(String str) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            charFreqMap.put(currChar, charFreqMap.getOrDefault(currChar, 0) + 1);
        }
        return charFreqMap;
    }
    public static void main(String[] args) {
        // System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        // System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
        // System.out.println("Rearranged string: " + RearrangeString.rearrangeString("bbbbaa"));
    }
}
