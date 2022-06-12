package leetcode;

import java.util.Arrays;

public class MinimumOperations_To_Reduce_X_To_Zero_1658 {

    public static void main(String[] args) {
        MinimumOperations_To_Reduce_X_To_Zero_1658 obj = new MinimumOperations_To_Reduce_X_To_Zero_1658();
        int x = 134365;
        int[] nums = {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309};

        System.out.println(obj.minOperations(nums, x));
    }

    /*
      We need to find minimum elements from ends whose sum is equal to x.
      That translates to we need to find out max len with sum = arraysum - x in middle

      Once we do this rest of elements from end will have sum x
     */
    public int minOperations(int[] nums, int x) {
        int arraySum = Arrays.stream(nums).sum();

        if (arraySum == x) {
            return nums.length;
        }

        //target to find in middle of array
        int target = arraySum -x;

        int start = 0, end =0, sum =0, windowSize =0;

        for (int i = 0; i < nums.length; i++) {

           //Not required
            /* if (nums[i] == target) {
                windowSize = Math.max(windowSize, 1); // single element start and end are same. so window size = 1
                if (windowSize == 1) {
                    //if current element equals target, set start and end to this element and sum equal to target
                    start = i;
                    end = i;
                    sum = target;
                }
                continue;
            }*/

            sum += nums[i];

            while (sum > target && start < nums.length) {
                sum = sum - nums[start];
                start++;
            }

            if (sum == target) {
                end =i;
                windowSize = Math.max(windowSize, end-start+1); // +1 to account for 0 based index
            }
        }

        return windowSize == 0 ? -1 : nums.length - windowSize;
    }
}
