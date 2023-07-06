package leetcode;

public class _209_MinimumSizeSubarraySum {

    public static void main(String[] args) {
        _209_MinimumSizeSubarraySum obj = new _209_MinimumSizeSubarraySum();

        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(obj.minSubArrayLen(target, nums));
    }

    /*
        Approach: Sliding window

        Keep on adding numbers till sum < target. Make note of length of sub-array

        Subtract the elements from start and see if we can get a smaller sub-array with sun >= target, if we do get update answer
        appropriately
     */
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, answer = Integer.MAX_VALUE, sum = 0;

        while (end < nums.length) {
            sum += nums[end];

            while (sum >= target) {
                answer = Math.min(answer, end-start+1);
                sum -= nums[start++];
            }
            end++;
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
