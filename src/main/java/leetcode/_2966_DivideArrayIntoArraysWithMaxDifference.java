package leetcode;

import java.util.Arrays;

public class _2966_DivideArrayIntoArraysWithMaxDifference {

    public static void main(String[] args) {
        _2966_DivideArrayIntoArraysWithMaxDifference obj = new _2966_DivideArrayIntoArraysWithMaxDifference();

        int[] nums = {1,3,4,8,7,9,3,5,1};
        int k = 2;
        System.out.println(Arrays.deepToString(obj.divideArray(nums, k)));
    }

    public int[][] divideArray(int[] nums, int k) {
        if (nums.length % 3 != 0) {
            return new int[][]{};
        }
        Arrays.sort(nums);
        int[][] answer = new int[nums.length/3][3];

        for (int i = 0; i < nums.length; ) {
            if (nums[i+2] - nums[i] > k) {
                return new int[][]{};
            }
            for (int j = 0; j < 3; j++) {
                answer[i/3][j] = nums[i++];
            }
        }
        return answer;
    }
}
