package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode https://leetcode.com/problems/shortest-word-distance-ii/
 * @date 230/7/2019
 * @Time n, m + n
 * @Space D D = number of unique words
 */
public class ShortestWordDistanceII {
    Map<String, List<Integer>> map = new HashMap<>();
    // n
    public ShortestWordDistanceII(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            List<Integer> list = map.getOrDefault(str, new ArrayList<Integer>());
            list.add(i);
            map.put(str, list);
        }
    }
    // m + n, same as merge sort
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            min = Math.min(min, Math.abs(index1 - index2));
            if (index1 < index2) {
                i++;
            } else {
                j++;
            }
        }
        return min;
    }
}
