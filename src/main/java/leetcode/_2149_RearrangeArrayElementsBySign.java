package leetcode;

import java.util.Arrays;

public class _2149_RearrangeArrayElementsBySign {

    public static void main(String[] args) {
        _2149_RearrangeArrayElementsBySign obj = new _2149_RearrangeArrayElementsBySign();

        int[] nums = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(obj.rearrangeArray(nums)));
    }

    public int[] rearrangeArray(int[] nums) {
        int[] answer = new int[nums.length];
        int positiveIndex = 0, negativeIndex = 1;

        for (int num : nums) {
            if (num < 0) {
                answer[negativeIndex] = num;
                negativeIndex += 2;
            } else {
                answer[positiveIndex] = num;
                positiveIndex += 2;
            }
        }
        return answer;
    }
}
