package leetcode;

import java.util.Arrays;
import java.util.List;

public class _3315_ConstructTheMinimumBitwiseArray_II {

    public static void main(String[] args) {
        _3315_ConstructTheMinimumBitwiseArray_II obj =
                new _3315_ConstructTheMinimumBitwiseArray_II();

        List<Integer> nums = List.of(2,3,5,7);
        System.out.println(Arrays.toString(obj.minBitwiseArray(nums)));
    }

    /*
        Same as LC-3314
     */
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);

            int res = -1;
            int d = 1;

            while ((num & d) != 0) {
                res = num - d;
                d <<= 1;
            }
            ans[i] = res;
        }
        return ans;
    }
}
