package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _3719_LongestBalancedSubarray_I {

    public static void main(String[] args) {
        _3719_LongestBalancedSubarray_I obj =
                new _3719_LongestBalancedSubarray_I();

        int[] nums = {2,5,4,3};
        System.out.println(obj.longestBalanced(nums));
    }

    public int longestBalanced(int[] nums) {
        int answer = 0;

        for (int left = 0; left < nums.length; left++) {
            Map<Integer, Integer> evenCount = new HashMap<>();
            Map<Integer, Integer> oddCount = new HashMap<>();

            for (int right = left; right < nums.length; right++) {
                if (nums[right] % 2 == 0) {
                    evenCount.merge(nums[right], 1, Integer::sum);
                } else {
                    oddCount.merge(nums[right], 1, Integer::sum);
                }

                if (evenCount.size() == oddCount.size()) {
                    answer = Math.max(answer, right - left + 1);
                }
            }
        }
        return answer;
    }
}
