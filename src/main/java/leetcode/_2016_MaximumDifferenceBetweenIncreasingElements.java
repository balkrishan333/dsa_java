package leetcode;

public class _2016_MaximumDifferenceBetweenIncreasingElements {

    public static void main(String[] args) {
        _2016_MaximumDifferenceBetweenIncreasingElements obj =
                new _2016_MaximumDifferenceBetweenIncreasingElements();

        int[] nums = {7,1,5,4};
        System.out.println(obj.maximumDifference(nums));
    }

    public int maximumDifference(int[] nums) {
        int result = -1;
        int preMinimum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > preMinimum) {
                result = Math.max(result, nums[i] - preMinimum);
            } else {
                preMinimum = nums[i];
            }
        }
        return result;
    }
}
