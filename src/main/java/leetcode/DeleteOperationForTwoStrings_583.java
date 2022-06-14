package leetcode;

public class DeleteOperationForTwoStrings_583 {

    public static void main(String[] args) {
        DeleteOperationForTwoStrings_583 obj = new DeleteOperationForTwoStrings_583();

//        String word1 = "sea", word2 = "eat";
//        String word1 = "leetcode", word2 = "etco";
//        String word1 = "sea", word2 = "ate";
        String word1 = "mart", word2 = "karma";
        System.out.println(obj.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        LongestCommonSubsequence_1143 obj = new LongestCommonSubsequence_1143();
        int length = obj.longestCommonSubsequence(word1, word2);

        return word1.length() + word2.length() - 2* length;
    }
}
