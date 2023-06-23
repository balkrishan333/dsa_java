package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1027_LongestArithmeticSubsequence {

    public static void main(String[] args) {
        _1027_LongestArithmeticSubsequence obj = new _1027_LongestArithmeticSubsequence();

        int[] nums = {20,1,15,3,10,5,8};
        System.out.println(obj.longestArithSeqLength(nums));
    }

    /*
        Approach: Dynamic programming

        For each element in array, store the difference (between this and all previous elements) and count of that difference
        whenever we encounter that same difference, increase the count and accordingly update maxLength
     */
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new Map[n]; // since we need to store difference and it can be -ve, we can't use 2D array, we need Map
        int maxLength = 0;

        for (int right = 0; right < n; right++) {
            dp[right] = new HashMap<>();
            for (int left = 0; left < right; left++) {
                int diff = nums[right] - nums[left]; // calculate the difference between right and all previous elements
                dp[right].put(diff, dp[left].getOrDefault(diff, 1) + 1); // if the same difference has been till left, increment the
                // count as we can draw a link between left and right as they have same difference.
                maxLength = Math.max(maxLength, dp[right].get(diff));
            }
        }
        return maxLength;
    }
}
