package leetcode;

import java.util.Arrays;

public class _1984_MinimumDifferenceBetweenHighestAndLowestOfKScores {

    public static void main(String[] args) {
        _1984_MinimumDifferenceBetweenHighestAndLowestOfKScores obj =
                new _1984_MinimumDifferenceBetweenHighestAndLowestOfKScores();

        int[] nums = {9,4,1,7};
        int k = 2;
        System.out.println(obj.minimumDifference(nums, k));
    }

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i+k-1 < nums.length; i++) {
            answer = Math.min(answer, nums[i+k-1]-nums[i]);
        }
        return answer;
    }
}
