package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _930_BinarySubarraysWithSum {

    public static void main(String[] args) {
        _930_BinarySubarraysWithSum obj = new _930_BinarySubarraysWithSum();

        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(obj.numSubarraysWithSum(nums, goal));
    }

    /*
        Approach: Prefix sum
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> freq = new HashMap<>();
        int currentSum = 0;
        int answer = 0;

        for (int num : nums) {
            currentSum += num;
            if (currentSum == goal) {
                answer ++;
            }
            // Check if there is any prefix sum that can be subtracted from the current sum to get the desired goal
            answer += freq.getOrDefault(currentSum-goal, 0);
            freq.merge(currentSum, 1 , Integer::sum);
        }
        return answer;
    }
}
