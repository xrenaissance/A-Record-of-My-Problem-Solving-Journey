package TopKElements;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/rearrange-string-k-distance-apart/
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/6244851517489152
 * @Time N + 2 * NlogN + N -> N log N
 * @Space 2N + k
 */
public class RearrangeStringKDistanceApart {
    public static String reorganizeString(String str, int k) {
        if (str == null || k <= 1) {
            return str;
        }
        Map<Character, Integer> charFreq = createFreqMap(str);
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );
        for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
            maxHeap.offer(entry);
        }
        Queue<Map.Entry<Character, Integer>> bufferQueue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currEntry = maxHeap.poll();
            currEntry.setValue(currEntry.getValue() - 1);
            result.append(currEntry.getKey());
            bufferQueue.offer(currEntry);
            if (bufferQueue.size() == k) {
                Map.Entry<Character, Integer> prevEntry = bufferQueue.poll();
                if (prevEntry.getValue() > 0) {
                    maxHeap.offer(prevEntry);
                }
            }
        }
        return result.length() == str.length() ? result.toString() : "";
    }
    private static Map<Character, Integer> createFreqMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
        }
        return map;
    }
    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 1));
    }
}
