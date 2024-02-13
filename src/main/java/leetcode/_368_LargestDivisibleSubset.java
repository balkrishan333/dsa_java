package leetcode;

import java.util.Arrays;
import java.util.List;

public class _368_LargestDivisibleSubset {

    public static void main(String[] args) {
        _368_LargestDivisibleSubset obj = new _368_LargestDivisibleSubset();
        int[] nums = {1,2,4,8};

        System.out.println(obj.largestDivisibleSubset(nums));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] chain = new int[nums.length];
        int[] count = new int[nums.length];

        int maxSize = 0;
        Arrays.sort(nums);
        int end = -1;

        for (int i = 0; i < nums.length; i++) {
            int max = 1;
            int prevIndex = -1;

            for (int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0 && count[j] +1 > max) {
                    prevIndex = j;
                    max = count[j] + 1;
                }
            }
            count[i] = max;
            chain[i] = prevIndex;

            if (count[i] > maxSize) {
                maxSize = count[i];
                end = i;
            }
        }
        List<Integer> result = new java.util.ArrayList<>();
        result.add(nums[end]);

        while (chain[end] != -1) {
            end = chain[end];
            result.add(nums[end]);
        }
        return result;
    }
}
