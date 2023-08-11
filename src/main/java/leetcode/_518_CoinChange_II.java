package leetcode;

import java.util.Arrays;

public class _518_CoinChange_II {

    public static void main(String[] args) {
        _518_CoinChange_II obj = new _518_CoinChange_II();

        int amount = 5;
        int[] coins = {1,2,5};
        System.out.println(obj.change(amount, coins));
    }

    /*
        Approach; Dynamic programming
     */
    int[][] dp;
    int[] coins;
    public int change(int amount, int[] coins) {

        dp = new int[coins.length][amount+1];
        this.coins = coins;

        for (int[] inner : dp) {
            Arrays.fill(inner, -1);
        }
        return change(0, amount);
    }

    private int change(int index, int amount) {
        if (amount == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        if (coins[index] > amount) {
            //leave current coin, as its value is more than amount
            dp[index][amount] = change(index+1, amount);
        } else {
            //consider current coin and try to reuse it for next amount + skip current coin
            dp[index][amount] = change(index, amount-coins[index]) + change(index+1, amount);
        }
        return dp[index][amount];
    }
}
