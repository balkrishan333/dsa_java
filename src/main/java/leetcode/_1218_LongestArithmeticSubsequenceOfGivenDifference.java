package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1218_LongestArithmeticSubsequenceOfGivenDifference {

    public static void main(String[] args) {
        _1218_LongestArithmeticSubsequenceOfGivenDifference obj = new _1218_LongestArithmeticSubsequenceOfGivenDifference();

        int[] arr = {1,5,7,8,5,3,4,2,1};
        int difference = -2;
        System.out.println(obj.longestSubsequence(arr, difference));
    }

    /*
        Approach: Dynamic programming

        For each element store the size of longest subsequence. For each incoming element check if element-difference exists, get that
        and increase the length till current element by 1 and store in map.
     */
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int answer = 0;

        for (int val :  arr) {
            int len = dp.getOrDefault(val-difference, 0);
            dp.put(val, len+1);
            answer = Math.max(answer, len+1);
        }
        return answer;
    }
}
