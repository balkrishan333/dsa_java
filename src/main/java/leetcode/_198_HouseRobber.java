package leetcode;

public class _198_HouseRobber {

    public static void main(String[] args) {
        _198_HouseRobber obj = new _198_HouseRobber();
        int[] nums = {2,1,1,2};
        System.out.println(obj.rob(nums));
    }

    public int rob(int[] nums) {
       int prev = 0, max = 0;

        for (int num : nums) {
            int temp = Math.max(prev+ num, max);
            prev = max; //prev is i-2 sum
            max = temp; //max is i-1 sum
        }
        return max;
    }
}
