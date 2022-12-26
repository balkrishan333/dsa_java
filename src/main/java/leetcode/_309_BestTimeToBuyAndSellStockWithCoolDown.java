package leetcode;

import java.util.Arrays;

public class _309_BestTimeToBuyAndSellStockWithCoolDown {

    public static void main(String[] args) {
        _309_BestTimeToBuyAndSellStockWithCoolDown obj = new _309_BestTimeToBuyAndSellStockWithCoolDown();
        int[] prices = {1,2,3,0,2};
        System.out.println(obj.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        Arrays.fill(dp, -1);
        return findMax(prices, 0, dp);
    }

    private int findMax(int[] prices, int curr, int[] dp) {
        //return 0, if current index crosses size of prices array
        if (curr >= prices.length) {
            return 0;
        }

        //return already calculated value for current index, if present
        if (dp[curr] != -1) {
            return dp[curr];
        }

        int max = 0;

        /*
            for current index, look at each element after that
            loop's only purpose is to find element with higher price and calculate max

         */
        for (int i = curr+1; i < prices.length; i++) {
            if (prices[curr] < prices[i]) {
                /*  if a higher price exists, take the difference between current element and next price element
                    and recursive call to method skipping one element. One skip for cool down.
                 */
                max = Math.max(max, prices[i] - prices[curr] + findMax(prices, i+2, dp));
            }
        }

        /*
            recursive call to find max from next element. This is makes sure we attempt buy at next element and then
            try to find another element with higher price and maximize the profit.

         */

        max = Math.max(max, findMax(prices, curr+1, dp));
        dp[curr] = max;

        return max;
    }
}
