package leetcode;

import java.util.Arrays;

public class _516_LongestPalindromicSubsequence {

    public static void main(String[] args) {
        _516_LongestPalindromicSubsequence obj = new _516_LongestPalindromicSubsequence();

        String s = "cbbd";
        System.out.println(obj.longestPalindromeSubseq(s));
    }

    /*
        Approach : Dynamic programming

        Check if first and last characters are same, include them in result and call the function again excluding both first and last
        chars (as they both have been considers)

        if first and last chars are not equal, you have 2 strings, first with excluding first char and second by excluding last char,
        invoke the function on both of them and take max.

        See inline comments
     */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        return longestPalindromeSubseq(0, s.length()-1, s.toCharArray(), dp);
    }

    private int longestPalindromeSubseq(int start, int end, char[] str, int[][] dp) {

        //if result has already been calculated for start and end, return that
        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        //if first and last char match, add 2 (because first and last chars will be included) and call function on rest of string
        if (str[start] == str[end]) {
            dp[start][end] = 2 + longestPalindromeSubseq(start+1, end-1, str, dp);
        } else {
            //if first and last chars don't match, take max of 2 strings: first by excluding first char and second by excluding last char
            dp[start][end] = Math.max(longestPalindromeSubseq(start, end-1, str, dp), longestPalindromeSubseq(start+1, end, str, dp));
        }

        return dp[start][end];
    }
}
