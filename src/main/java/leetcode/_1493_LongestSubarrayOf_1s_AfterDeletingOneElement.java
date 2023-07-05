package leetcode;

public class _1493_LongestSubarrayOf_1s_AfterDeletingOneElement {

    public static void main(String[] args) {
        _1493_LongestSubarrayOf_1s_AfterDeletingOneElement obj = new _1493_LongestSubarrayOf_1s_AfterDeletingOneElement();

        int[] nums = {0,1,1,1,0,1,1,0,1};
        System.out.println(obj.longestSubarray(nums));
    }

    /*
        Approach: Sliding window

        Maintain a window with single zero and find maxLength each time we see a new zero
     */
    public int longestSubarray(int[] nums) {
        int zeroIndex = -1;
        int start = 0;
        int maxLength = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroIndex == -1) {
                    zeroIndex = i;
                } else {
                    //calculate maxLength
                    maxLength = Math.max(maxLength, i-start-1);
                    start = zeroIndex +1; // move past zero in current window
                    zeroIndex = i; //set zeroIndex to currentZero
                }
            }
        }
        return Math.max(maxLength, nums.length-start-1);
    }
}
