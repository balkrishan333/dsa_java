package leetcode;

public class _122_BestTimeToBuyAndSellStock_II {

    public static void main(String[] args) {
        _122_BestTimeToBuyAndSellStock_II obj = new _122_BestTimeToBuyAndSellStock_II();

        int[] prices = {7,1,5,3,6,4};
        System.out.println(obj.maxProfit(prices));
    }

    /*
        Approach: Dynamic programming with 2 arrays

        On each day we can either buy the stock or sell the stock or do nothing. We can't take a single array for dp and work with that
        because that will give us maximum profit on that day, but it will not consider the state of stock. State of stock means, whether
        its currently in hold or free. Stock is on hold if it has been purchased but not sold after purchased. If it is not purchased
        or sold after purchased its in free state.

        When we buy the stock, we need to calculate new profit by taking the previous day profit from free array because we can't
        purchase the held stock

        When we sell the stock, we need to calculate new profit by taking the previous day profit from hold array because we can't sell
        the free stock
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] free = new int[n];
        int[] hold = new int[n];

        free[0] = 0; //on first day no purchase was made, so profit will be 0
        hold[0] = -prices[0];//on first day purchase was made but no sold, so profit is -(price in first day)

        for (int i = 1; i < n; i++) {
            free[i] = Math.max(free[i-1], hold[i-1] + prices[i]); //since we are selling, add the price to profit
            hold[i] = Math.max(hold[i-1], free[i-1] - prices[i]); //since we are buying, subtract the price from profit
        }

        return free[n-1];
    }
}
