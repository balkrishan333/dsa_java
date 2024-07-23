package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1636_SortArrayByIncreasingFrequency {

    public static void main(String[] args) {
        _1636_SortArrayByIncreasingFrequency obj = new _1636_SortArrayByIncreasingFrequency();

        int[] nums = {2,3,1,3,2};
        System.out.println(Arrays.toString(obj.frequencySort(nums)));
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.merge(num, 1 , Integer::sum);
        }

        // Java's Arrays.sort method doesn't directly support
        // sorting primitive arrays (int[]) with a lambda comparator.
        // We can convert the primitive int into Integer objects
        // to get around this limitation.
        Integer[] numObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numObj[i] = nums[i];
        }

        Arrays.sort(numObj, (a, b) -> {
            if (frequency.get(a).equals(frequency.get(b))) {
                return Integer.compare(b, a);
            }
            return Integer.compare(frequency.get(a), frequency.get(b));
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numObj[i];
        }
        return nums;
    }
}
