package leetcode;

import java.util.Arrays;

public class _1498_NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    public static void main(String[] args) {
        _1498_NumberOfSubsequencesThatSatisfyTheGivenSumCondition obj = new _1498_NumberOfSubsequencesThatSatisfyTheGivenSumCondition();

        int[] nums = {14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14};
        int target = 22;

        System.out.println(obj.numSubseq(nums, target));
    }

    /*
        Approach: Sort the array. Use 2 pointer approach.

        1. start with left = 0, right = nums.len-1
        2. if sum of elements at position left and right is more than target, move right one place left
        3. if sum of elements at position left and right is less than or equal target, total number of combinations are 2^(right-left),
        add this to answer and take mode

        why total number of combinations are 2^(right-left)

        In a array of length n, total possible subsequences are 2^n. With no. of elements between left and right index being
        (right-left), so total possible subsequences are 2^(right-left)
     */
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1_000_000_007;

        int answer = 0;
        int left = 0, right = nums.length-1;

        int[] power = new int[nums.length];
        power[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
                continue;
            }

            answer = (answer + power[right-left]) % mod;
            left++;
        }
        return answer;
    }
}
