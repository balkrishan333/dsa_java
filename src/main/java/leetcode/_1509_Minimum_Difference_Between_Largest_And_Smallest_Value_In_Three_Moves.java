package leetcode;

import java.util.Arrays;

public class _1509_Minimum_Difference_Between_Largest_And_Smallest_Value_In_Three_Moves {

    public static void main(String[] args) {
        _1509_Minimum_Difference_Between_Largest_And_Smallest_Value_In_Three_Moves obj =
                new _1509_Minimum_Difference_Between_Largest_And_Smallest_Value_In_Three_Moves();

        int[] nums = {1,5,6,13,14,15,16,17};
        System.out.println(obj.minDifference(nums));
    }

    /*
        Time - O(nlog(n))
        space - O(1)
     */
    public int minDifference(int[] nums) {

        if (nums.length < 5) {
            return 0;
        }

        Arrays.sort(nums);

        /*
            There are four possible optimal scenarios

            1. Removing the three largest elements.
            2. Removing the two largest and one smallest elements.
            3. Removing one largest and two smallest elements.
            4. Removing the three smallest elements.

            For an array of size 10, it would mean
            1. difference between (9, 3)
            2. difference between (8, 2)
            3. difference between (7, 1)
            4. difference between (6, 0)
         */

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            result = Math.min(result, nums[nums.length - 1 - i] - nums[3 - i]);
        }
        return result;
    }
}
