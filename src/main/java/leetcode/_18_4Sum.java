package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _18_4Sum {

    public static void main(String[] args) {
        _18_4Sum obj = new _18_4Sum();

        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(obj.fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = nums[i] + nums[j];

                if (map.containsKey(target - sum)) {
                    List<List<Integer>> lists = map.get(target-sum);

                    for (List<Integer> list : lists) {
                        result.add(List.of(list.get(0), list.get(1), nums[i], nums[j]));
                    }
                }
            }
            for (int j = 0; j < i; j++) {
                int sum = nums[i] + nums[j];
                List<List<Integer>> lists = map.get(sum);
                if (lists == null) {
                    lists = new ArrayList<>();
                }
                lists.add(List.of(nums[i], nums[j]));
                map.put(sum, lists);
            }
        }
        return result;
    }
}
