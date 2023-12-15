package leetcode;

import java.util.Arrays;

public class _2952_MinimumNumberOfCoinsToBeAdded {

    public static void main(String[] args) {
        _2952_MinimumNumberOfCoinsToBeAdded obj = new _2952_MinimumNumberOfCoinsToBeAdded();

        int[] coins = {1,4,10};
        int target = 19;
        System.out.println(obj.minimumAddedCoins(coins, target));
    }

    public int minimumAddedCoins(int[] coins, int target) {
        int coinsRequired = 0;
        long maxReach = 0;

        Arrays.sort(coins);

        int index = 0;
        while (maxReach < target) {
            if (index < coins.length && coins[index] <= maxReach+1) {
                maxReach += coins[index]; //max reach will be current reach + value of current coin
                index++;
            } else {
                //being here means current coin is more than next number to reach, so we need to add coin to fill the gap. Value of coin
                // to be added is maxReach+1 because we need to cover each value till target amd maxReach+1 is not reachable
                maxReach += maxReach+1; //max reach will be current reach + value of next coin which will be added
                coinsRequired++;
            }
        }
        return coinsRequired;
    }
}
