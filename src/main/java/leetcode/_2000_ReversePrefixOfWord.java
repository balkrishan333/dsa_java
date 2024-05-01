package leetcode;

public class _2000_ReversePrefixOfWord {

    public static void main(String[] args) {
        _2000_ReversePrefixOfWord obj = new _2000_ReversePrefixOfWord();

        String word = "abcdefd";
        char ch = 'd';
        System.out.println(obj.reversePrefix(word, ch));
    }

    public String reversePrefix(String word, char ch) {
        char[] chars = new char[word.length()];
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }

        int j = 0;
        for (int i = index; i >= 0; i--) {
            chars[j++] = word.charAt(i);
        }

        for (int i = index+1; i < word.length(); i++) {
            chars[j++] = word.charAt(i);
        }

        return new String(chars);
    }
}
