package leetcode;

import java.util.Arrays;

public class _2389_LongestSubsequenceWithLimitedSum {

    public static void main(String[] args) {
        _2389_LongestSubsequenceWithLimitedSum obj = new _2389_LongestSubsequenceWithLimitedSum();

        int[] nums = {4,5,2,1};
        int[] queries = {3,10,21};
        System.out.println(Arrays.toString(obj.answerQueries(nums, queries)));
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int[] answers = new int[queries.length];
        Arrays.fill(answers, 0);

        Arrays.sort(nums);  // nlog n

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }

        for (int i = 0; i < queries.length; i++) {
            int index = Arrays.binarySearch(nums, queries[i]);
            answers[i] = Math.abs(index + 1);
        }
        return answers;
    }

    /*
        Time complexity: nlog n + n * m
     */
    public int[] answerQueries_v1(int[] nums, int[] queries) {
        int[] answers = new int[queries.length];
        Arrays.fill(answers, 0);

        Arrays.sort(nums);  // nlog n

        for (int i = 0; i < queries.length; i++) {  //n^2
            int index = Arrays.binarySearch(nums, queries[i]);
            int sum =0, seq = 0;

            if (index < 0) {
                index = -(index+1)-1;
            }
            for (int j = 0; j <= index; j++) {
                if (sum + nums[j] <= queries[i]) {
                    sum += nums[j];
                    seq++;
                }
            }
            answers[i] = seq;
        }
        return answers;
    }
}
