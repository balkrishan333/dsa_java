package leetcode;

import java.util.Arrays;

public class _2270_NumberOfWaysToSplitArray {

    public static void main(String[] args) {
        _2270_NumberOfWaysToSplitArray obj = new _2270_NumberOfWaysToSplitArray();

        int[] nums = {10,4,-8,7};
        System.out.println(obj.waysToSplitArray(nums));
    }

    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int count = 0;

        long prefix = 0;
        for (int i = 0; i < nums.length-1; i++) {
            prefix += nums[i];
            if (prefix >= sum - prefix) {
                count++;
            }
        }
        return count;
    }
}
