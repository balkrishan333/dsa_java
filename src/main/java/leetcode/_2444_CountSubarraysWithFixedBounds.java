package leetcode;

public class _2444_CountSubarraysWithFixedBounds {

    public static void main(String[] args) {
        _2444_CountSubarraysWithFixedBounds obj = new _2444_CountSubarraysWithFixedBounds();

        int[] nums = {1,3,5,2,7,5};
        int minK = 1, maxK = 5;
        System.out.println(obj.countSubarrays(nums, minK, maxK));
    }

    /*
        Approach: Sliding window

        Iterate through all the elements and at each step update the index of minK, maxK and index of element out of
        range. if both min and max are not -1, add to answer. See inline comments
     */
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int min = -1, max = -1, leftOutOfRange = -1;

        long answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minK) {
                min = i;
            }

            if (nums[i] == maxK) {
                max = i;
            }

            if (nums[i] < minK || nums[i] > maxK) {
                leftOutOfRange = i;
            }

            if (min != -1 && max != -1) {
                int step = Math.min(min, max) - leftOutOfRange; // can be negative, if recent element is out of
                // range, so need to skip next step calculation by taking max of 0 and step.
                answer += Math.max(0, step); //ignore if step is less than 0
            }
        }
        return answer;
    }
}
