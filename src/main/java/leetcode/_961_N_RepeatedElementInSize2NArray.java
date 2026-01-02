package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _961_N_RepeatedElementInSize2NArray {

    public static void main(String[] args) {
        _961_N_RepeatedElementInSize2NArray obj =
                new _961_N_RepeatedElementInSize2NArray();

        int[] nums = {5,1,5,2,5,3,5,4};
        System.out.println(obj.repeatedNTimes(nums));
    }

    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
            if (count.get(num) > 1) {
                return num;
            }
        }
        return -1;
    }
}
