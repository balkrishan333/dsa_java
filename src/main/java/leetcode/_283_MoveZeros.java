package leetcode;

import java.util.Arrays;

public class _283_MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        _283_MoveZeros obj = new _283_MoveZeros();

        obj.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[++index] = nums[i];
            }
        }

        index++;
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
