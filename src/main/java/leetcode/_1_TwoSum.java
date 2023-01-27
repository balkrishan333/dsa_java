package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {

    public static void main(String[] args) {
        _1_TwoSum obj = new _1_TwoSum();
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(obj.twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> indexTrack = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer diffIndex = indexTrack.get(target - nums[i]);
            if (diffIndex != null) {
                return new int[]{i, diffIndex};
            } else {
                indexTrack.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
