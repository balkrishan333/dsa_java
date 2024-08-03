package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1460_MakeTwoArraysEqualByReversingSubarrays {

    public static void main(String[] args) {
        _1460_MakeTwoArraysEqualByReversingSubarrays obj = new _1460_MakeTwoArraysEqualByReversingSubarrays();

        int[] target = {1,2,3,4};
        int[] arr = {2,4,1,3};
        System.out.println(obj.canBeEqual(target, arr));
    }

    public boolean canBeEqual(int[] target, int[] arr) {

        Map<Integer, Integer> arrFreq = new HashMap<>();
        for (int num : arr) {
            arrFreq.merge(num, 1, Integer::sum);
        }

        for (int num : target) {
            if (!arrFreq.containsKey(num)) {
                return false;
            }

            // Decrement the frequency count for num and
            // remove key if the count goes to 0
            arrFreq.merge(num,- 1, Integer::sum);
            if (arrFreq.get(num) == 0) {
                arrFreq.remove(num);
            }
        }
        return arrFreq.isEmpty();
    }
}
