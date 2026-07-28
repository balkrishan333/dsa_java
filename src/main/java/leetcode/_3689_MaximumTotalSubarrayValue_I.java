package leetcode;

public class _3689_MaximumTotalSubarrayValue_I {

    public static void main(String[] args) {
        _3689_MaximumTotalSubarrayValue_I obj =
                new _3689_MaximumTotalSubarrayValue_I();

        int[] nums = {1,3,2};
        int k = 2;
        System.out.println(obj.maxTotalValue(nums, k));
    }

    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (long) (max - min) * k;
    }
}
