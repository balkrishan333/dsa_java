package leetcode;

import java.util.Arrays;

public class _1402_ReducingDishes {

    public static void main(String[] args) {
        _1402_ReducingDishes obj = new _1402_ReducingDishes();

        int[] satisfaction = {-1,-8,0,5,-9};
        System.out.println(obj.maxSatisfaction(satisfaction));
    }

    /*
        Recursive and Dp solution to find max
     */
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[] dp = new int[satisfaction.length];
        return findMax(satisfaction, 0, dp);
    }

    private int findMax(int[] satisfaction, int index, int[] dp) {
        if (index >= satisfaction.length) {
            return 0;
        }

        if (dp[index] != 0) {
            return dp[index];
        }

        int sum = 0, j = 1;
        for (int i = index; i < satisfaction.length; i++) {
            sum += satisfaction[i] * j++;
        }

        int max = Math.max(sum, findMax(satisfaction, index+1, dp));
        dp[index] = max;
        return max;
    }
}
