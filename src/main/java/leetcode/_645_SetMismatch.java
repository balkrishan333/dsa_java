package leetcode;

import java.util.Arrays;

public class _645_SetMismatch {

    public static void main(String[] args) {
        _645_SetMismatch obj = new _645_SetMismatch();

        int[] nums = new int[]{1,2,2,4};
        System.out.println(Arrays.toString(obj.findErrorNums(nums)));
    }

    public int[] findErrorNums(int[] nums) {
        int[] answer = new int[2];
        boolean[] exists = new boolean[nums.length+1];

        int sum = 0;
        for (int num : nums) {
            if (exists[num]) {
                answer[0] = num;
            }
            sum += num;
            exists[num] = true;
        }

        int n = nums.length;
        /*
        sum of first n natutal numbers is n*(n+1)/2. Find the difference between expected sum and actual sum and add that difference to
        repeated number to get the number that is missing.
         */
        answer[1] = answer[0] + (n* (n+1)/2) - sum;
        return answer;
    }
}
