package leetcode;

import java.util.Arrays;

public class _1877_MinimizeMaximumPairSumInArray {

    public static void main(String[] args) {
        _1877_MinimizeMaximumPairSumInArray obj = new _1877_MinimizeMaximumPairSumInArray();

        int[] nums = {3,5,4,2,4,6};
        System.out.println(obj.minPairSum(nums));
    }

    /*
        Approach: Sort the array and take sum of smallest and largest element as we need to minimize the sum this way we make sure 2
        largest elements are never summed up.

        Since an element can be considered once, we use 2 pointer approach and move both pointers towards each other at each step.
     */
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;

        for (int i = 0, j = nums.length-1; i < j; i++,j--) {
            int sum = nums[i] + nums[j];
            max = Math.max(max, sum);
        }
        return max;
    }
}
