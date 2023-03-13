package leetcode;

import java.util.Arrays;

public class _905_SortArrayByParity {

    public static void main(String[] args) {
        _905_SortArrayByParity obj = new _905_SortArrayByParity();
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
