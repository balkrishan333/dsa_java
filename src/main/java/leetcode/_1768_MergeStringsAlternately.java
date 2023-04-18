package leetcode;

public class _1768_MergeStringsAlternately {

    public static void main(String[] args) {
        _1768_MergeStringsAlternately obj = new _1768_MergeStringsAlternately();

        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(obj.mergeAlternately(word1, word2));
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int i =0;
        for (; i < word1.length() && i < word2.length(); i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if (i < word1.length()) {
            sb.append(word1.substring(i));
        }else if (i < word2.length()) {
            sb.append(word2.substring(i));
        }
        return sb.toString();
    }
}
