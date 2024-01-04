package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _2870_MinimumNumberOfOperationsToMakeArrayEmpty {

    public static void main(String[] args) {
        _2870_MinimumNumberOfOperationsToMakeArrayEmpty obj = new _2870_MinimumNumberOfOperationsToMakeArrayEmpty();

        int[] nums = {2,3,3,2,2,4,2,3,4};
        System.out.println(obj.minOperations(nums));
    }

    public int minOperations(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }

        int answer = 0;
        for (int value : count.values()) {
            if (value == 1) {
                return -1;
            }
            answer += (int)Math.ceil((double) value/3);
        }
        return answer;
    }
}
