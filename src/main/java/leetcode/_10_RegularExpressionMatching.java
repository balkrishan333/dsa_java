package leetcode;

public class _10_RegularExpressionMatching {

    public static void main(String[] args) {
        _10_RegularExpressionMatching obj = new _10_RegularExpressionMatching();

        System.out.println(obj.isMatch("aa", "a*"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        // Handle patterns with '*'
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2] || (dp[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'));
                }
            }
        }
        return dp[m][n];
    }
}
