package leetcode;

public class _3652_BestTimeToBuyAndSellStockUsingStrategy {

    public static void main(String[] args) {
        _3652_BestTimeToBuyAndSellStockUsingStrategy obj =
                new _3652_BestTimeToBuyAndSellStockUsingStrategy();

        int[] prices = {4,2,8};
        int[] strategy = {-1,0,1};
        int k = 2;
        System.out.println(obj.maxProfit(prices, strategy, k));
    }

    public long maxProfit(int[] prices, int[] strategy, int k) {
        long originalProfit = 0;
        int n = prices.length;

        //step 1 : calculate the original profit
        for (int i = 0; i < n; i++) {
            originalProfit += (long) prices[i] * strategy[i];
        }
        long maxProfit = originalProfit;

        //step 2 : calculate the profit after applying the window of size k, initial window
        long oldWindowProfit = 0;
        long sellSum = 0;
        for (int i = 0; i < k; i++) {
            oldWindowProfit += (long) prices[i] * strategy[i];
            if (i >= k/2) {
                sellSum += prices[i];
            }
        }

        maxProfit = Math.max(maxProfit, originalProfit - oldWindowProfit + sellSum);

        for (int i = 1; i + k <= n; i++) {
            int outIndex = i - 1;
            int inIndex = i + k - 1;

            oldWindowProfit = oldWindowProfit - (long) prices[outIndex] * strategy[outIndex]
                                            + (long) prices[inIndex] * strategy[inIndex];

            int sellOutIndex = i - 1 + k/2;
            int sellInIndex = i + k - 1;

            sellSum = sellSum - prices[sellOutIndex] + prices[sellInIndex];

            long candidateProfit = originalProfit - oldWindowProfit + sellSum;
            maxProfit = Math.max(maxProfit, candidateProfit);
        }
        return maxProfit;
    }
}
