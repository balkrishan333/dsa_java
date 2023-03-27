package leetcode;

public class _583_DeleteOperationForTwoStrings {

    public static void main(String[] args) {
        _583_DeleteOperationForTwoStrings obj = new _583_DeleteOperationForTwoStrings();

//        String word1 = "sea", word2 = "eat";
//        String word1 = "leetcode", word2 = "etco";
//        String word1 = "sea", word2 = "ate";
        String word1 = "mart", word2 = "karma";
        System.out.println(obj.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        _1143_LongestCommonSubsequence obj = new _1143_LongestCommonSubsequence();
        int length = obj.longestCommonSubsequence(word1, word2);

        return word1.length() + word2.length() - 2* length;
    }
}
