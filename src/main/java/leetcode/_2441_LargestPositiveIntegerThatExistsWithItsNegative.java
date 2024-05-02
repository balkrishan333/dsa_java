package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _2441_LargestPositiveIntegerThatExistsWithItsNegative {

    public static void main(String[] args) {
        _2441_LargestPositiveIntegerThatExistsWithItsNegative obj = new _2441_LargestPositiveIntegerThatExistsWithItsNegative();

        int[] nums = {-1,10,6,7,-7,1};
        System.out.println(obj.findMaxK(nums));
    }

    public int findMaxK(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int result = -1;
        for (int num : nums) {
            if (map.containsKey(Math.abs(num))) {
                int val = map.get(Math.abs(num));
                if (val == -num) {
                    result = Math.max(result, Math.abs(num));
                }
            } else {
                map.put(Math.abs(num), num);
            }
        }
        return result;
    }
}
