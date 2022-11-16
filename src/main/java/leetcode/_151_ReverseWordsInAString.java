package leetcode;

public class _151_ReverseWordsInAString {

    public static void main(String[] args) {
        _151_ReverseWordsInAString obj = new _151_ReverseWordsInAString();

        String s = "  hello world  ";
        System.out.println(obj.reverseWords(s));
    }

    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i = words.length-1; i >= 0; i--) {
            if (words[i].length() > 0) {
                sb.append(words[i].trim());
                sb.append(" ");
            }
        }
        return sb.substring(0, sb.length()-1);
    }
}
