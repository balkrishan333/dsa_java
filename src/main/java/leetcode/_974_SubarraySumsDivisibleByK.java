package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _974_SubarraySumsDivisibleByK {

    public static void main(String[] args) {
        _974_SubarraySumsDivisibleByK obj = new _974_SubarraySumsDivisibleByK();

//        int[] nums = {4,5,0,-2,-3,1};
//        int k = 5;

        int[] nums = {-1,2,9};
        int k = 2;
        System.out.println(obj.subarraysDivByK(nums, k));
    }

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        /*
         our sum is initially 0, and 0 is also divisible by k
         there would be a case when remainder would actually be zero
         so the array from the beginning to that index is our candidate subarray
         so to address that case, so we put <0, 1> initially
         */
        count.put(0, 1);

        int sum = 0;
        int answer = 0;
        for (int num : nums) {
            sum += num;

            int remainder = sum % k;
            if (remainder < 0) {
                /*
                    why we need to make sure remainder is +ve

                    We add current frequency to answer in next line. This is because if we encounter the same
                    remainder again that will happen only if a number equal to k has been add in sum. so there
                    lies a sequence between last  same remainder and current remainder which sums to k hence
                    perfectly divisible by k; Eg: remainder 4, will come again only if we add 5,10. 15 etc to sum

                    if we don't make remainder positive, we can rely on above assumption because remainder is
                    same just number is -ve. Eg: remainder -4, if we add 5, we should be
                    adding 1 to answer, but we won't do that because earlier remainder was -ve and  remainder will be 1

                     use case: nums = {-1,2,9}, k = 2
                 */
                remainder += k;
            }
            answer += count.getOrDefault(remainder, 0);
            count.merge(remainder, 1, Integer::sum);
        }
        return answer;
    }
    /*
        naive solution
        Time complexity - O(n^2)
     */

    /*public int subarraysDivByK(int[] nums, int k) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if(sum % k == 0) {
                answer++;
            }
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if(sum % 5 == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }*/
}
