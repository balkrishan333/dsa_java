package leetcode;

public class _1646_GetMaxInGeneratedArray {

    public static void main(String[] args) {
        _1646_GetMaxInGeneratedArray obj = new _1646_GetMaxInGeneratedArray();

        int n =5;

        System.out.println(obj.getMaximumGenerated(n));
    }

    public int getMaximumGenerated(int n) {
        if(n==0) {
            return 0;
        }

        if(n==1) {
            return 1;
        }

        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;

        int max = 1;

        for(int i = 0; i < n ; i++) {
            if(2*i <= n) {
                nums[2*i] = nums[i];
                max = Math.max(nums[2*i], max);
            }

            if(2*i+1 <=n) {
                nums[2*i+1] = nums[i] + nums[i+1];
                max = Math.max(nums[2*i+1], max);
            }
        }
        return max;
    }
}
