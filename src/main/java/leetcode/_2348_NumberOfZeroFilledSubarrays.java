package leetcode;

public class _2348_NumberOfZeroFilledSubarrays {

    public static void main(String[] args) {
        _2348_NumberOfZeroFilledSubarrays obj = new _2348_NumberOfZeroFilledSubarrays();

        int[] nums = {0,0,0,2,0,0};
        System.out.println(obj.zeroFilledSubarray(nums));
    }

    /*
        Approach: Find the sub array which contains all zeros, then no of sub arrays (of different size) which all contain zero in this
        sub array can be calculated as n * (n+1)/2 where n is size of sub array
     */
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            } else {
                if (start != -1) {
                    int subArrSize = end - start +1;
                    count += (long) (subArrSize) * (subArrSize+1)/2;
                }
                start = -1;
                end = -1;
            }
        }

        if (start != -1) {
            int subArrSize = end - start +1;
            count += (long) (subArrSize) * (subArrSize+1)/2;
        }

        return count;
    }
}
