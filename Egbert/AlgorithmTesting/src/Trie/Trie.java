package Trie;
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/**
 * @leetcode https://leetcode.com/problems/implement-trie-prefix-tree/
 * @Space N
 * @Time M = length of word
 */
public class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    // add at any index
    public void add(String word, int index) {
        if (index == word.length()) {
            return;
        }
        TrieNode now = root;
        for (int i = index; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (now.children[ch - 'a'] == null) {
                now.children[ch - 'a'] = new TrieNode();
            }
            now = now.children[ch - 'a'];
        }
        now.hasWord = true;
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        add(word, 0);
    }
    // Find word at any index, and return TrieNode, also for blury search ..abc
    public TrieNode find(String word, TrieNode node, int index) {
        if (index == word.length()) {
            return node;
        }
        TrieNode now = node;
        Character ch = word.charAt(index);
        if (ch == '.') {
            for (int j = 0; j < 26; j ++) {
                if (now.children[j] != null) {
                    TrieNode result = find(word, now.children[j], index + 1);
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        } else if (now.children[ch - 'a'] != null) {
            return find(word, now.children[ch - 'a'], index + 1);
        } else {
            return null;
        }
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = find(word, root, 0);
        return node != null && node.hasWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix, root, 0);
        return node != null;
    }
    public class TrieNode {
        TrieNode[] children;
        boolean hasWord;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
