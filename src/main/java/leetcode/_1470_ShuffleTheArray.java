package leetcode;

import java.util.Arrays;

public class _1470_ShuffleTheArray {

    public static void main(String[] args) {
        _1470_ShuffleTheArray obj = new _1470_ShuffleTheArray();

        int n = 3;
        int[] nums = {2,5,1,3,4,7};
        System.out.println(Arrays.toString(obj.shuffle(nums, n)));
    }

    public int[] shuffle(int[] nums, int n) {
        int[] answer = new int[2*n];

        int index = 0;
        for (int i = 0, j = n; j < 2*n; i++,j++) {
            answer[index++] = nums[i];
            answer[index++] = nums[j];
        }

        return answer;
    }
}
