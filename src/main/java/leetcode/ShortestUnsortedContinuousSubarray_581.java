package leetcode;

public class ShortestUnsortedContinuousSubarray_581 {

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray_581 obj = new ShortestUnsortedContinuousSubarray_581();

//        int[] nums = {2,6,4,8,10,9,15};
//        int[] nums = {1,2,3,4};
//        int[] nums = {2,3,3,2,4};
//        int[] nums = {1,2,4,5,3};
        int[] nums = {1,3,5,4,2};

        System.out.println(obj.findUnsortedSubarray(nums));
    }

    public int findUnsortedSubarray(int[] nums) {

        if (nums == null || nums.length == 1) {
            return 0;
        }

        int start = -1, end = -1, max;

        if (nums[0] > nums[1]) {
            start = 0;
            end = 1;
            max = nums[0];
        } else {
            max = nums[1];
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < max || nums[i] < nums[i-1]) {
                if (start == -1) {
                    start = i-1;

                    start = adjustStartIfRequired(nums, start, i);
                }
                end = i;
                start = adjustStartIfRequired(nums, start, i);
            }

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        if (start == -1) {
            return 0;
        }
        return end - start +1;
    }

    private int adjustStartIfRequired(int[] nums, int start, int i) {
        int j = start -1;
        /*
            back track to take care of duplicate and less numbers
            For e.g: 2,3,3,2,4
         */
        while (j >= 0) {
            if (nums[j] == nums[start] || nums[j] > nums[i]) {
                j--;
            } else {
                break;
            }
        }
        start = j + 1;
        return start;
    }
}
