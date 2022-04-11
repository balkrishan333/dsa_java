package geekforgeeks;

public class LongestPlaindrome_5 {

    public static void main(String[] args) {
//        String s = "daba";
        String s = "aacabdkacaa";
        String longestPalindrome = longestPalindrome(s);
        System.out.println("longestPalindrome = " + longestPalindrome);
    }

    public static String longestPalindrome(String s) {
        if (s.length() <2) {
            return s;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = null;
        int maxLen = 0;
        int start =0;

        for (int i = n-1; i >=0; i--) {
            for (int j = i; j < n; j++) {

                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i < 2 || dp[i+1][j-1]);

                if (dp[i][j]) {
                    if (j-i+1 > maxLen) {
                        maxLen = j-i+1;
                        //res = s.substring(i, i+maxLen);
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
}
