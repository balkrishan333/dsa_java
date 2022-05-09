package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxNumbersOfKSumPairs_1679 {

    public static void main(String[] args) {
        MaxNumbersOfKSumPairs_1679 obj = new MaxNumbersOfKSumPairs_1679();
        int[] nums = {3,1,3,4,3};
        int k = 6;

        System.out.println(obj.maxOperations(nums, k));
    }

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.merge(nums[i], 1, Integer::sum);
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer val_1 = count.get(nums[i]);
            if (val_1 != null && val_1 != 0) {

                Integer val_2 = count.get(k - nums[i]);

                if (val_2 != null) {
                    if (nums[i] == k-nums[i]) {
                        if (val_2 >= 2) {
                            result++;
                            count.merge(nums[i], -2, Integer::sum);
                        }
                    } else {
                        if (val_2 >= 1) {
                            result++;
                            count.merge(nums[i], -1, Integer::sum);
                            count.merge(k-nums[i], -1, Integer::sum);
                        }
                    }
                }
            }
        }
        return result;
    }
}
