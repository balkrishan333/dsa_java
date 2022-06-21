package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {

    public static void main(String[] args) {
        _15_3Sum obj = new _15_3Sum();

        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println(obj.threeSum(nums));
    }

    /*
        1. Sort the array
        2. Fix 1 element - i
        3. Iterate through rest of the array with 2 pointers (start and end)
        4. While iterating find 2 elements with sum = target - nums[i]
     */
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i-1] != nums[i]) {
                int low = i+1;
                int high = nums.length-1;
                int sum = 0-nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        res.add(List.of(nums[i], nums[low], nums[high]));
                        low++;
                        high--;
                        //skip all elements with same value, to avoid duplicates
                        while (high < nums.length-1 && low < high && nums[high] == nums[high+1]) {
                            high--;
                        }
                        //skip all elements with same value, to avoid duplicates
                        while (low > 0 && low < high && nums[low-1] == nums[low]) {
                            low++;
                        }

                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return res;
    }
}
