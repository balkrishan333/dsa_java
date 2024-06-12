package leetcode;

import java.util.Arrays;

public class _75_SortColors {

    public static void main(String[] args) {
        _75_SortColors obj = new _75_SortColors();

        int[] nums = {2,0,2,1,1,0};
        obj.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int[] count = new int[3];

        for (int num : nums) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }
}
