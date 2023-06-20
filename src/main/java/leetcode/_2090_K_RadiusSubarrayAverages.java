package leetcode;

import java.util.Arrays;

public class _2090_K_RadiusSubarrayAverages {

    public static void main(String[] args) {
        _2090_K_RadiusSubarrayAverages obj = new _2090_K_RadiusSubarrayAverages();

        int[] nums = {1,11,17,21,29};
        int k = 4;
        System.out.println(Arrays.toString(obj.getAverages(nums, k)));
    }

    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1);

        if (2*k+1 > nums.length) {
            return answer;
        }

        long sum = 0;
        for (int i = 0; i <= 2*k; i++) {
            sum += nums[i];
        }
        answer[k] = (int)(sum / (2*k+1));
        int start = 0, pointer = k+1;

        for (int i = 2*k+1; i < nums.length; i++) {
            sum -= nums[start++];
            sum += nums[i];
            answer[pointer++] = (int)(sum / (2*k+1));
        }
        return answer;
    }
}
