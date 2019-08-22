package TopologicalSort;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/alien-dictionary/
 * @param V total number of different characters
 * @param E total number of rules, since each pair can give us one rule
 * so E is the length of alien dictionary
 * @Time V + E
 * @Space V + E
 */
public class AlienDictionary {
    public static String findOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        // Graph initialization
        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        for ( String word : words) {
            for (int i = 0; i < word.length(); i++) {
                inDegree.put(word.charAt(i), 0);
                graph.putIfAbsent(word.charAt(i), new ArrayList<>());
            }
        }
        // Build Graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLength = Math.min(w1.length(), w2.length());
            for (int j = 0; j < minLength; j++) {
                char parent = w1.charAt(j);
                char child = w2.charAt(j);
                if (parent != child) {
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                    // only the first different char between two words can find order
                    break;
                }
            }
        }
        // Find All source point
        Queue<Character> source = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                source.offer(entry.getKey());
            }
        }
        // Traverse source points, remove, its child's degree - 1, if = 0, then
        // new source point is formed
        StringBuilder sortOrder = new StringBuilder();
        while (!source.isEmpty()) {
            char vertex = source.poll();
            sortOrder.append(vertex);
            for (Character child : graph.get(vertex)) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    source.offer(child);
                }
            }
        }
        // check if possible
        if (sortOrder.length() != inDegree.size()) {
            return "";
        }
        return sortOrder.toString();
    }

    public static void main(String[] args) {
        String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "ywx", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);
    }
}
