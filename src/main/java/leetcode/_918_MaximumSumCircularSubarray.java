package leetcode;

import java.util.Arrays;

public class _918_MaximumSumCircularSubarray {

    public static void main(String[] args) {
        _918_MaximumSumCircularSubarray obj = new _918_MaximumSumCircularSubarray();

        int[] nums = {-1,-2,-3,10,-4,-5,6,5};
        System.out.println(obj.maxSubarraySumCircular(nums));
    }

    public int maxSubarraySumCircular(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        //step 1 - find max using kadane's algo
        int max =Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum = Math.max(num, currentSum + num);
            max = Math.max(max, currentSum);
        }

        //step 2 - find min using kadane's algo
        int min =Integer.MAX_VALUE;
        currentSum = 0;

        for (int num : nums) {
            currentSum = Math.min(num, currentSum + num);
            min = Math.min(min, currentSum);
        }

        //step 3 - find sum of array
        int sum = Arrays.stream(nums).sum();

        if (sum == min) {
            return max;
        }

        return Math.max(max, sum-min);
    }
}
