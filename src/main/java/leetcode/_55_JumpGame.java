package leetcode;

public class _55_JumpGame {

    public static void main(String[] args) {
        _55_JumpGame obj = new _55_JumpGame();

        int[] nums = {2,3,1,1,4};
        System.out.println(obj.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }

        if (nums[0] == 0) {
            return false;
        }
        int maxReached = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i > maxReached) {
                return  false;
            }

            maxReached = Math.max(maxReached, nums[i] + i);

            if (maxReached >= nums.length-1) {
                return true;
            }
        }

        return maxReached >= nums.length-1;
    }
}
