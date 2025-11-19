package leetcode;

import java.util.Arrays;

public class _2154_KeepMultiplyingFoundValuesByTwo {

    public static void main(String[] args) {
        _2154_KeepMultiplyingFoundValuesByTwo obj =
                new _2154_KeepMultiplyingFoundValuesByTwo();

        int[] nums = {5,3,6,1,12};
        int original = 3;
        System.out.println(obj.findFinalValue(nums, original));
    }

    public int findFinalValue(int[] nums, int original) {
        int[] arr = new int[1001];
        Arrays.fill(arr, -1);

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = nums[i];
        }

        boolean elementExists = arr[original] != -1;
        while (elementExists) {
            original = original * 2;
            elementExists = original <= arr.length && arr[original] != -1;
        }
        return original;
    }
}
