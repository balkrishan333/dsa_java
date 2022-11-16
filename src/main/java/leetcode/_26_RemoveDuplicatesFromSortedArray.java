package leetcode;

import java.util.Arrays;

public class _26_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        _26_RemoveDuplicatesFromSortedArray obj = new _26_RemoveDuplicatesFromSortedArray();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        System.out.println(obj.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int next = 1; int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                nums[next++] = nums[i];
                prev = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return next;
    }
}
