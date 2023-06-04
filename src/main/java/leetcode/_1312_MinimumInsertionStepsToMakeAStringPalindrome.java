package leetcode;

import java.util.Arrays;

public class _1312_MinimumInsertionStepsToMakeAStringPalindrome {

    public static void main(String[] args) {
        _1312_MinimumInsertionStepsToMakeAStringPalindrome obj = new _1312_MinimumInsertionStepsToMakeAStringPalindrome();

        String s = "zzazz";
        System.out.println(obj.minInsertions(s));
    }

    /*
        Approach: DP

        Take reverse of string and find the longest command substring(lcs) between original and its reverse. Answer would be length of
        string minus length of lcs
     */
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        String sReverse = new StringBuilder(s).reverse().toString();
        //starting with last character. bottom up DP approach
        return s.length() - lcs(s, sReverse, s.length()-1, s.length()-1, dp);
    }

    private int lcs(String original, String reverse, int i, int j, int[][] dp) {

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        //if both characters are same, increment the size of lcs and move both pointers one place left (as we started with rightmost
        // characters)
        if (original.charAt(i) == reverse.charAt(j)) {
            dp[i][j] = lcs(original, reverse, i-1, j-1, dp) + 1 ;
            return dp[i][j];
        }

        //if characters are not equal, move one pointer at a time keeping other at same position and take max of both of them
        dp[i][j] = Math.max(lcs(original,reverse, i-1, j, dp), lcs(original, reverse, i, j-1, dp));

        return dp[i][j];
    }
}
