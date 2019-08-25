package Trie;
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

/**
 * @leetcode https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * @param N = length of the new Word
 * @param M = total number of the characters in the trie
 * @Time addWord N, find word will be M
 * @Space M
 */
public class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (now.children[ch - 'a'] == null) {
                now.children[ch - 'a'] = new TrieNode();
            }
            now = now.children[ch - 'a'];
        }
        now.hasWord = true;
    }
    /** find word at any index */
    public boolean find(String word, TrieNode node, int index) {
        if (index == word.length()) {
            return node.hasWord;
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (find(word, node.children[i], index + 1)) {
                        return true;
                    }
                }
            }
            return false;
        } else if (node.children[ch - 'a'] != null) {
            return find(word, node.children[ch - 'a'], index + 1);
        } else {
            return false;
        }
    }
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, root, 0);
    }
    public static class TrieNode {
        TrieNode[] children;
        boolean hasWord;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
