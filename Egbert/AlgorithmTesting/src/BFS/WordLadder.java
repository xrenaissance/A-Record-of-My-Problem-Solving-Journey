package BFS;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/word-ladder/
 * @lintcode https://www.lintcode.com/problem/word-ladder/description?_from=ladder&&fromId=14
 * @param m average length of string
 * @param n length of dict
 * @Time m * nre
 * @Space m * n worst for visited hashset
 */
public class WordLadder {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        // get all possible selections for each position
        Map<Integer, Set<Character>> selections = new HashMap<>();
        int length = start.length();
        for (String str : dict) {
            for (int i = 0; i < length; i++) {
                selections.computeIfAbsent(i, k -> new HashSet<>()).add(str.charAt(i));
            }
        }
        for (int i = 0; i < end.length(); i++) {
            Set<Character> set = selections.get(i);
            set.add(end.charAt(i));
            selections.put(i, set);
        }
        queue.offer(start);
        int dist = 1;
        Set<String> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            // level order traversal
            for (int i = 0; i < size; i++) {
                String currString = queue.poll();
                // get all possible state for all possible selections at each position
                for (int k = 0; k < length; k++) {
                    for (Character ch : selections.get(k)) {
                        char[] array = currString.toCharArray();
                        array[k] = ch;
                        String next = new String(array);
                        if (next.equals(end)) {
                            return dist;
                        }
                        if (dict.contains(next) && !visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Map<Integer, Set<Character>> map = new HashMap<>();
        String start = "hit";
        String end = "cog";
        String[] dict = new String[] {"hot","dot","dog","lot","log"};
        for (int i = 0; i < dict.length; i++) {
            String str = dict[i];
            for (int j = 0; j < str.length(); j++) {
                map.computeIfAbsent(j, k -> new HashSet<Character>())
                        .add(str.charAt(j));
            }
        }
        for (int i = 0; i < end.length(); i++) {
            Set<Character> set = map.get(i);
            set.add(end.charAt(i));
            map.put(i, set);
        }
        for (Map.Entry<Integer, Set<Character>> entry : map.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}
