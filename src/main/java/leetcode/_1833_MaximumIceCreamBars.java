package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _1833_MaximumIceCreamBars {

    public static void main(String[] args) {
        _1833_MaximumIceCreamBars obj = new _1833_MaximumIceCreamBars();

        int[] costs = {1,3,2,4,1};
        int coins = 7;
        System.out.println(obj.maxIceCream(costs, coins));
    }

    public int maxIceCream(int[] costs, int coins) {
        if (coins == 0 || costs.length == 0) {
            return 0;
        }

        Arrays.sort(costs);
        int count = 0;

        for (int i = 0; i < costs.length && coins > 0; i++) {
            coins = coins - costs[i];
            if (coins < 0) {
                break;
            }
            count++;
            if(coins == 0) {
                break;
            }
        }

        return count;
    }
}
