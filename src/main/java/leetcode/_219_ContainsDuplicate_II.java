package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _219_ContainsDuplicate_II {

    public static void main(String[] args) {
        _219_ContainsDuplicate_II obj = new _219_ContainsDuplicate_II();

        int[] nums = {99,99};
        int k = 3;
        System.out.println(obj.containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int index = valueToIndexMap.getOrDefault(nums[i], -1);
            if (index != -1 && Math.abs(index-i) <= k) {
                return true;
            }
            valueToIndexMap.put(nums[i], i);
        }
        return false;
    }
}
