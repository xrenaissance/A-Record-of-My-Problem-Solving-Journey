package Hash;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

/**
 * @leetcode https://leetcode.com/problems/repeated-dna-sequences/
 * @Time HashMap: 10 N, N for Set
 * @Space N/2 worst
 */
public class RepeatedDNASequences {
    // Set solution N
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        Set<String> filter = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if (!filter.add(str)) {
                res.add(str);
            }
        }
        return new ArrayList<>(res);
    }
    // Solution2 : HashMap + sliding window M * N M = 10
    public List<String> findRepeatedDnaSequencesMap(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        int windowStart = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int windowEnd = 9; windowEnd < s.length(); windowEnd++) {
            String str = s.substring(windowStart++, windowEnd + 1);
            map.put(str, map.getOrDefault(str, 0) + 1);
            if (map.get(str) == 2) {
                result.add(str);
            }
        }
        return result;
    }
}
