package leetcode;

import java.util.Arrays;

public class _746_MinCostClimbingStairs {

    public static void main(String[] args) {
        _746_MinCostClimbingStairs obj = new _746_MinCostClimbingStairs();

        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(obj.minCostClimbingStairs(cost));
    }

    private int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length+1];
        Arrays.fill(dp, -1);

        return Math.min(calcCost(0, cost), calcCost(1, cost));
    }

    private int calcCost(int step, int[] cost) {

        if (step >= cost.length) {
            return 0;
        }

        if (dp[step] != -1) {
            return dp[step];
        }

        int stepCost = cost[step] + Math.min(calcCost(step+1, cost), calcCost(step+2, cost));
        dp[step] = stepCost;

//        System.out.println("step, stepCost = " + step + "," + stepCost);
        return stepCost;
    }
}
