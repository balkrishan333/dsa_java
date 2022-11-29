package leetcode;

public class _279_PerfectSquares {

    public static void main(String[] args) {
        _279_PerfectSquares obj = new _279_PerfectSquares();
        int n = 25;

        System.out.println(obj.numSquares(n));

    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                int count = 1;

                count += dp[i-j*j];
                min = Math.min(min, count);

            }
            dp[i] = min;
        }
        return dp[n];
    }
}
