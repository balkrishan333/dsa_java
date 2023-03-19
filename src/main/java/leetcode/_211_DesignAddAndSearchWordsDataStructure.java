package leetcode;

public class _211_DesignAddAndSearchWordsDataStructure {

    private final TrieNode root;

    public static void main(String[] args) {
        _211_DesignAddAndSearchWordsDataStructure wordDictionary = new _211_DesignAddAndSearchWordsDataStructure();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("b")); // return False
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }

    public _211_DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }

    /*
        Approach: Use trie

        When searching in Trie need to handle wildcard char '.'. See method comments for details
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (node.children[currChar-'a'] == null) {
                node.children[currChar-'a'] = new TrieNode();
            }
            node = node.children[currChar-'a'];
        }
        node.word = word; //do this only for the last node. This mean word is non-empty string only for nodes which correspond to last
        // character in string
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    /*
        Recursively called to match one character at a time.
     */
    private boolean match(char[] charArray, int chIndex, TrieNode node) {
        if (chIndex == charArray.length) {
            return !node.word.equals(""); //this is required to make sure we don't match the partial string. Eg: Trie contains dad but we
            // search for 'd' and we need to check for empty string not for string being searched for because string might have wildcard
            // character '.' and it will never match the trie. So, rather we match for not empty string and string is non-empty only when
            // we reach a node which corresponds to end of string
        }
        char currChar = charArray[chIndex];
        if (currChar != '.') {
            return node.children[currChar-'a'] != null && match(charArray, chIndex + 1, node.children[currChar-'a']);
        } else {
            //in case of '.' search every node which is not null and then pursue to find next character
            for(TrieNode child : node.children) {
                if (child != null && match(charArray, chIndex+1, child)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = "";
    }
}
