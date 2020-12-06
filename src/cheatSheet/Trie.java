package cheatSheet;


public class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;

        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.containsKey(c)) {
                cur.put(c, new TrieNode());
            }
            cur = cur.get(c);
        }

        cur.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;

        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.containsKey(word.charAt(i))) {
                cur = cur.get(word.charAt(i));
            } else {
                return false;
            }
        }

        return cur.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String word) {
        if (word == null || word.length() == 0) return false;
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.containsKey(word.charAt(i))) {
                cur = cur.get(word.charAt(i));
            } else {
                return false;
            }
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class TrieNode {
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}