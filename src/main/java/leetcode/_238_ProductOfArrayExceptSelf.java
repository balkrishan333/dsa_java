package leetcode;

import java.util.Arrays;

public class _238_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        _238_ProductOfArrayExceptSelf obj = new _238_ProductOfArrayExceptSelf();

        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(obj.productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1; //for first element there is no prefix
        suffix[n-1] = 1; //for last element there is no suffix

        for (int i = 1; i < n; i++) { //start from 1 as prefix for first element is always 1 stated above
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for (int i = n-2; i >= 0; i--) { //start from n-2 as suffix for last element is always 1 as stated above
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = prefix[i] * suffix[i];
        }
        return answer;
    }
}
