package SlidingWindow;
import java.util.*;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/4559641746866176
 * @author Egbert Li
 * @date 22/06/2019
 */
public class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        if (str == null) {
            return resultIndices;
        }
        Map<String, Integer> strFreqMap = new HashMap<>();
        int windowSize = 0;
        for (String word : words) {
           strFreqMap.put(word, strFreqMap.getOrDefault(word, 0) + 1);
           windowSize += word.length();
        }
        int windowStart = 0;
        int matched = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            continue;
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
        result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(result);
    }
}
