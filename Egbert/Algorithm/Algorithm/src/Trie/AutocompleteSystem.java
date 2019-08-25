package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
public class AutocompleteSystem {
    TrieNode root;
    StringBuilder prefix;
    public static void main(String[] args) {
        List<String> titles = new ArrayList<>();
        titles.add("abcdefg");
        titles.add("abcf");

        List<String> body = new ArrayList<>();
        body.add("abcf");
        body.add("abcf");
        body.add("abcf");
        body.add("abcf");
        body.add("abcf");
        body.add("abcf");
        body.add("abcf");
        body.add("abcf");
        body.add("abcf");
        body.add("abcf");
        body.add("abcf");
        body.add("bee");

        List<String> qs = new ArrayList<>();
        qs.add("a");
        qs.add("abc");
        qs.add("b");
        qs.add("beef");
        AutocompleteSystem acs = new AutocompleteSystem();
        for (Integer i : acs.getAutocompleteScores(titles, body, qs)) {
            System.out.println(i);
        }

    }
    public static List<Integer> getAutocompleteScores(List<String> documentTitles,
                                                      List<String> documentBodies,
                                                      List<String> queries) {
        TrieNode root = new TrieNode();
        Map<String, Integer> freq = new HashMap<String, Integer> ();
        for ( String s : documentTitles) {
            freq.put(s, freq.getOrDefault(s, 0) + 10);
            add(s, freq.get(s), root);
        }
        for (String s : documentBodies) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
            add(s,freq.get(s), root);
        }
        List<Integer> result = new ArrayList<Integer> ();
        for (String query: queries) {
            result.add(search(query, root));
        }
        return result;
    }
    private static void add(String s, int score, TrieNode root) {
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            TrieNode next = curr.children.get(c);
            if (next == null) {
                next = new TrieNode();
                curr.children.put(c, next);
            }
            curr = next;
            curr.maxScore = Math.max(curr.maxScore, score);
        }
        curr.maxScore = Math.max(curr.maxScore, score);
        curr.isWord = true;
    }

    public static int search(String s, TrieNode root) {
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            TrieNode next = curr.children.get(ch);
            if (next == null) {
                return 0;
            }
            curr = next;
        }
        return curr.maxScore;
    }
    static class TrieNode {
        Map<Character, TrieNode> children;
        int maxScore = Integer.MIN_VALUE;
        boolean isWord;
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            isWord = false;
        }
    }
}
