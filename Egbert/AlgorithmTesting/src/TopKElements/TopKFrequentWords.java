package TopKElements;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/top-k-frequent-words/
 * @date 16/7/2019
 * @Time n + (n + k)logk
 * @Space N + k
 */
public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) {
            new ArrayList<String>();
        }
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                k, (a, b) -> a.getValue() - b.getValue() == 0 ?
                b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );
        Map<String, Integer> freqMap = getFreqMap(words);
        List<String> topK = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        for (int j = 0; j < k; j++) {
            topK.add(0, minHeap.poll().getKey());
        }
        return topK;
    }
    public static Map<String, Integer> getFreqMap(String[] words) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        return freqMap;
    }
    public static void main(String[] args) {
        System.out.println("i".compareToIgnoreCase("love"));
        String[] input1 = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String[] input2 = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(TopKFrequentWords.topKFrequent(input1, 4));
        System.out.println(TopKFrequentWords.topKFrequent(input2, 2));
        System.out.println(TopKFrequentWords.topKFrequent(input2, 1));
        System.out.println(TopKFrequentWords.topKFrequent(input2, 3));
    }
}
