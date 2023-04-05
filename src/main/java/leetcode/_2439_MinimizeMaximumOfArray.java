package leetcode;

public class _2439_MinimizeMaximumOfArray {

    public static void main(String[] args) {
        _2439_MinimizeMaximumOfArray obj = new _2439_MinimizeMaximumOfArray();

        int[] nums = {3,7,1,6};
        System.out.println(obj.minimizeArrayValue(nums));
    }

    /*
        Approach: prefix sum

        Calculate sum of i elements at each ith step during iteration, take average and check max
        This works because we can only distribute values in forward direction (subtract from previous and to current
        element), so we choose the element, take average of sum and distribute value.
     */
    public int minimizeArrayValue(int[] nums) {
        long answer = 0;
        long prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            /*
            Use either of below 2 lines. 2nd line avoid ceil operation because ceil is equivalient to (num + demo -1)
            so, prefixSum + i+1 -i == prefixSum+1
             */
//            answer = (long) Math.max(answer, Math.ceil(prefixSum/(i+1.0))); //need to use 1.0 for widening
//            calculations and cast at end to double
            answer = Math.max(answer, (prefixSum+i)/(i+1));
        }

        return (int)answer;
    }
}
