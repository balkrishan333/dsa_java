package leetcode;

public class _3573_BestTimeToBuyAndSellStock_V {

    public static void main(String[] args) {
        _3573_BestTimeToBuyAndSellStock_V obj =
                new _3573_BestTimeToBuyAndSellStock_V();

        int[] prices = {1,7,9,8,2};
        int k = 2;
        System.out.println(obj.maximumProfit(prices, k));
    }

    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][] dp = new long[n][k + 1][3];

        //initialize for day 0
        for (int transaction = 1; transaction <= k; transaction++) {
            dp[0][transaction][0] = 0; // No stock held
            dp[0][transaction][1] = -prices[0]; // Holding stock after buying on day 0
            dp[0][transaction][2] = prices[0]; // Sold stock,
        }

        for (int day = 1; day < n; day++) {
            for (int transaction = 1; transaction <= k; transaction++) {
                dp[day][transaction][0] = Math.max(dp[day-1][transaction][0],
                                                        Math.max(dp[day-1][transaction][1] + prices[day],
                                                                dp[day-1][transaction][2] - prices[day]));

                dp[day][transaction][1] = Math.max(dp[day-1][transaction][1],
                                                        dp[day-1][transaction-1][0] - prices[day]);

                dp[day][transaction][2] = Math.max(dp[day-1][transaction][2],
                                                        dp[day-1][transaction-1][0] + prices[day]);
            }
        }
        return dp[n-1][k][0];
    }
}
