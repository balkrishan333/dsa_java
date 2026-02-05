package leetcode;

import java.util.Arrays;

public class _3379_TransformedArray {

    public static void main(String[] args) {
        _3379_TransformedArray obj =
                new _3379_TransformedArray();

        int[] nums = {-9,-9};
        System.out.println(Arrays.toString(obj.constructTransformedArray(nums)));
    }

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = nums[i];
            } else {
                //(i + nums[i]) calculates the raw target index (can be negative or exceed bounds)
                //% n brings it within range but may still be negative in Java
                //+ n shifts negative results to positive
                //% n again ensures the final index is in [0, n-1]
                int index = ((i + nums[i]) % n + n) % n;
                result[i] = nums[index];
            }
        }
        return result;
    }
}
