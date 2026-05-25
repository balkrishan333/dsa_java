package leetcode;

public class _55_JumpGame {

    public static void main(String[] args) {
        _55_JumpGame obj = new _55_JumpGame();

        int[] nums = {2,3,1,1,4};
        System.out.println(obj.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        // Single element array — already at the last index
        if(nums.length == 1) {
            return true;
        }

        // If first element is 0, we can never leave index 0
        if (nums[0] == 0) {
            return false;
        }

        // Tracks the farthest index we can reach from any position seen so far
        int maxReached = 0;
        for (int i = 0; i < nums.length; i++) {
            // If current index is beyond what we can reach, there's a gap (caused by zeros)
            // e.g., [1,0,2] → at i=2, maxReached is still 1, so we can't get here
            if (i > maxReached) {
                return  false;
            }

            // From position i, we can reach up to i + nums[i]
            maxReached = Math.max(maxReached, i + nums[i]);

            // If our reach covers the last index, we can land on it
            // (we don't have to jump the full nums[i], we can choose a shorter jump)
            if (maxReached >= nums.length-1) {
                return true;
            }
        }
        return maxReached >= nums.length-1;
    }
}
