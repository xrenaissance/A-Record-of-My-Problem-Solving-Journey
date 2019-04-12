package StringI;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author Egbert Li
 * @date 12/04/2019
 * Time complexity: O(n) + klogk
 * Space compelxity: O(k)
 */
public class TopKFrequentWordsMinHeapSol {
    public String[] topKFrequent(String[] combo, int k) {
        if (combo == null || combo.length == 0) {
            return combo;
        }
        Map<String, Integer> record = buildMap(combo);
        PriorityQueue<Map.Entry<String, Integer>> minHeap =
                new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
                        return m1.getValue().compareTo(m2.getValue());
                    }
                });
        // traverse record with minHeap  klog(k)
        for (Map.Entry<String, Integer> entry : record.entrySet()){
            if (k > 0) {
                minHeap.offer(entry);
                k--;
            } else {
                if (entry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }
        // klogk
        int i = minHeap.size() - 1;
        String[] result = new String[minHeap.size()];
        while (!minHeap.isEmpty()) {
            result[i] = minHeap.poll().getKey();
            i--;
        }
        return result;
    }
    // O(n)
    private Map<String, Integer> buildMap(String[] combo) {
        Map<String, Integer> record = new HashMap<>();
        for (String elem : combo) {
            if (record.containsKey(elem)) {
                record.put(elem, record.get(elem) + 1);
            } else {
                if (elem != null) {
                    record.put(elem, 1);
                }
            }
        }
        return record;
    }
}
