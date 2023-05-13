package leetcode;

import java.util.Arrays;

public class _2466_CountWaysToBuildGoodStrings {

    private static final int MOD = 1_000_000_007;
    public static void main(String[] args) {
        _2466_CountWaysToBuildGoodStrings obj = new _2466_CountWaysToBuildGoodStrings();

        int low = 2, high = 3, zero = 1, one = 2;
        System.out.println(obj.countGoodStrings(low, high, zero, one));
    }

    /*
        Approach - Dynamic programming
     */
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        Arrays.fill(dp, -1);

        dp[0] = 1;
        int answer = 0;
        for (int i = low; i <= high; i++) {
            answer +=countGoodStrings(i, zero, one, dp);
            answer = answer % MOD;
        }
        return answer;
    }

    private int countGoodStrings(int len, int zero, int one, int[] dp) {

        if (dp[len] != -1) {
            return dp[len];
        }

        int count = 0;

        if (len >= zero) {
            count += countGoodStrings(len - zero, zero, one, dp);
        }

        if (len >= one) {
            count += countGoodStrings(len - one, zero, one, dp);
        }

        return dp[len] = (count % MOD);
    }
}
