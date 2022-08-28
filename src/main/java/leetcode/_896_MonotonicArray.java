package leetcode;

import static java.lang.System.out;

public class _896_MonotonicArray {

    public static void main(String[] args) {
        _896_MonotonicArray obj = new _896_MonotonicArray();

        int[] nums = {1,3,3,4,8,9,9,10};
        out.println(obj.isMonotonic(nums));
    }

    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i+1]) {
                decreasing = false;
            } else if (nums[i] > nums[i+1]) {
                increasing = false;
            }
        }
        return increasing || decreasing;
    }
}
