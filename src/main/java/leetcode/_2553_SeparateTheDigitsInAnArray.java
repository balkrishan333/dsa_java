package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2553_SeparateTheDigitsInAnArray {

    public static void main(String[] args) {
        _2553_SeparateTheDigitsInAnArray obj =
                new _2553_SeparateTheDigitsInAnArray();

        int[] nums = {13,25,83,77};
        System.out.println(Arrays.toString(obj.separateDigits(nums)));
    }

    public int[] separateDigits(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> temp = new ArrayList<>();
            while (num > 0) {
                temp.add(num % 10);
                num /= 10;
            }

            for (int j = temp.size()-1; j >=0 ; j--) {
                list.add(temp.get(j));
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
