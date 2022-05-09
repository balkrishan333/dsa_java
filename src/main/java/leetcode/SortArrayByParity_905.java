package leetcode;

import java.util.Arrays;

public class SortArrayByParity_905 {

    public static void main(String[] args) {
        SortArrayByParity_905 obj = new SortArrayByParity_905();
        int[] nums = {0};

        System.out.println(Arrays.toString(obj.sortArrayByParity(nums)));
    }

    public int[] sortArrayByParity(int[] nums) {
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int tmp = nums[++index];
                nums[index] = nums[i];
                nums[i] = tmp;
            }
        }
        return nums;
    }
}
