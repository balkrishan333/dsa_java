package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _16_3SumClosest {

    public static void main(String[] args) {
        _16_3SumClosest obj = new _16_3SumClosest();

        int[] nums = {0,0,0};
        int target = 1;
        System.out.println(obj.threeSum(nums, target));
    }

    /*
        1. Sort the array
        2. Fix 1 element - i
        3. Iterate through rest of the array with 2 pointers (start and end)
        4. While iterating find 2 elements with sum = target - nums[i]
     */
    public int threeSum(int[] nums, int target) {

        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            int sum = target - nums[i];

            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    return target;
                } else {
                    closest = Math.min(closest, target - Math.abs(nums[i] + nums[low] + nums[high]));
                    if (nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return Math.abs(closest);
    }
}
