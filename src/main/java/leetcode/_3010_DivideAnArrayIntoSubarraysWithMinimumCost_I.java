package leetcode;

public class _3010_DivideAnArrayIntoSubarraysWithMinimumCost_I {

    public static void main(String[] args) {
        _3010_DivideAnArrayIntoSubarraysWithMinimumCost_I obj =
                new _3010_DivideAnArrayIntoSubarraysWithMinimumCost_I();

        int[] nums = {5,4,3};
        System.out.println(obj.minimumCost(nums));
    }

    /*
        Approach: Since 1st element is the cost of the sub-array, nums[0] will be cost of 1st sub-array
        so, we need to find 2 minimum elements from rest of the array

        cost will be nums[0]+min1+min2
     */
    public int minimumCost(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return nums[0] + min1 + min2;
    }
}
