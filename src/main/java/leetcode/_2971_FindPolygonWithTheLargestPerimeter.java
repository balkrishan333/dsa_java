package leetcode;

import java.util.Arrays;

public class _2971_FindPolygonWithTheLargestPerimeter {

    public static void main(String[] args) {
        _2971_FindPolygonWithTheLargestPerimeter obj = new _2971_FindPolygonWithTheLargestPerimeter();

//        int[] nums = {1,12,1,2,5,50,3};
        int[] nums = {300005055,352368231,311935527,315829776,327065463,388851949,319541150,397875604,311309167,391897750,366860048,
                359976490,325522439,390648914,359891976,369105322,350430086,398592583,354559219,372400239,344759294,379931363,308829137,
                335032174,336962933,380797651,378305476,336617902,393487098,301391791,394314232,387440261,316040738,388074503,396614889,
                331609633,374723367,380418460,349845809,318514711,308782485,308291996,375362898,397542455,397628325,392446446,368662132,
                378781533,372327607,378737987};
        System.out.println(obj.largestPerimeter(nums));
    }

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }

        long answer = -1;

        for (int i = 2; i < nums.length; i++) {
            if (prefixSum[i-1] > nums[i]) {
                answer = prefixSum[i-1] + nums[i];
            }
        }
        return answer;
    }
}
