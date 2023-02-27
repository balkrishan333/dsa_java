package leetcode;

public class _72_EditDistance {

    public static void main(String[] args) {
        _72_EditDistance obj = new _72_EditDistance();

        String word1 = "horse", word2 = "ros";
        System.out.println(obj.minDistance(word1, word2));
    }

    /*
        Approach: Dynamic programming

        We can do 3 operations - insert, delete and replace

        We need to find out which operation requires the least edits to make 2  strings equals.

        So, at each step check all 3 operations and take minimum of them.
     */
    public int minDistance(String word1, String word2) {

        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }

        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }

        if (word1.equals(word2)) {
            return 0;
        }

        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {

                //if 2 chars are equal, no extra edits are require, so take whatever was there till previous chars
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {

                    //find out for no. of edits for all 3 operations and take min
                    int replace = dp[i-1][j-1];
                    int insert = dp[i-1][j];
                    int delete = dp[i][j-1];

                    //add 1 for current operations. +1 will always be required because being in else means 2 characters
                    //are not equal
                    dp[i][j] = Math.min(delete, Math.min(insert, replace)) +1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
