package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1814_CountNicePairsInAnArray {

    public static void main(String[] args) {
        _1814_CountNicePairsInAnArray obj = new _1814_CountNicePairsInAnArray();

        int[] nums = {42,11,1,97};
        System.out.println(obj.countNicePairs(nums));
    }

    /*
        Approach:

        x + rev(y) == y + rev(x) can be re written as
        x - rev(x) == y - rev(y)  //expr-1

        Create a new array with value as expr-1. For each array count the number of times a difference occurs and add to answer

     */
    public int countNicePairs(int[] nums) {
        int[] revs = new int[nums.length];
        int mod = 1000000007;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int rev = 0;
            while (num > 0) {
                rev = rev *10 + num%10;
                num = num/10;
            }
            revs[i] = nums[i] - rev;
        }

        Map<Integer, Integer> count = new HashMap<>();
        int answer = 0;
        for (int rev : revs) {
            count.merge(rev, 1 , Integer::sum);
            if (count.get(rev) > 1) {
                answer += count.get(rev) -1; //subtract 1 because we need to exclude current element and new number of pairs will be
                // equals to no of elements in array excluding the newly added one
                answer = answer % mod;
            }
        }
        return answer;
    }
}
