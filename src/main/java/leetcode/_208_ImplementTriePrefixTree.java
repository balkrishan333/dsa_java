package leetcode;

public class _208_ImplementTriePrefixTree {

    private final TrieNode root;

    public static void main(String[] args) {
        _208_ImplementTriePrefixTree obj = new _208_ImplementTriePrefixTree();
        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
        obj.insert("app");
        System.out.println(obj.search("app"));
    }

    public _208_ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.children[currentChar-'a'] == null) {
                node.children[currentChar-'a'] = new TrieNode();
            }
            node = node.children[currentChar-'a'];
        }
        node.end = true;
    }

    public boolean search(String word) {
        TrieNode node = findWith(word);
        return  node != null && node.end;
    }

    public boolean startsWith(String prefix) {
        return findWith(prefix) != null;
    }

    private TrieNode findWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (node.children[currentChar-'a'] == null) {
                return null;
            }
            node = node.children[currentChar-'a'];
        }
        return node;
    }

    private static class TrieNode {
        boolean end;
        TrieNode[] children = new TrieNode[26];
    }
}
