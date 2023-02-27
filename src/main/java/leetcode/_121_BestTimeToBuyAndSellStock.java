package leetcode;

public class _121_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        _121_BestTimeToBuyAndSellStock obj = new _121_BestTimeToBuyAndSellStock();

        int[] prices = {7,1,5,3,6,4};
        System.out.println(obj.maxProfit(prices));
    }

    /*
        Approach:

        For each element we need to find max element from elements with higher index.

        We start backwards and keep track of max seen so far. When we reach an element we already know the max element
        from elements with higher index. Now we just need to make sure we calculate the profit and take max of it.
     */
    public int maxProfit(int[] prices) {
        int profit = 0, max = prices[prices.length-1];

        for (int i = prices.length-2; i >=0 ; i--) {
            profit = Math.max(profit, max-prices[i]);
            max = Math.max(max, prices[i]);
        }
        return profit;
    }
}
