package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _2425_BitwiseXOROfAllPairings {

    public static void main(String[] args) {
        _2425_BitwiseXOROfAllPairings obj = new _2425_BitwiseXOROfAllPairings();

        int[] nums1 = {2,1,3}, nums2 = {10,2,5,0};
        System.out.println(obj.xorAllNums(nums1, nums2));
    }

    /*
        XOR with itself results in 0: a ^ a = 0
        XOR with 0 results in the same number: a ^ 0 = a

        Because XOR is commutative (the order of operations doesn’t matter), we can rearrange this to group elements together:

        Each element of nums1 appears n2 times in the calculation (where n2 is the size of nums2).
        Each element of nums2 appears n1 times in the calculation (where n1 is the size of nums1).

        Elements appearing an even number of times contribute 0 to the final result.
        Elements appearing an odd number of times retain their value in the final result.

     */
    public int xorAllNums(int[] nums1, int[] nums2) {
        Map<Integer, Integer> frequency = new HashMap<>();

        int nums1Len = nums1.length;
        int nums2Len = nums2.length;

        for (int num : nums1) {
            frequency.merge(num, nums2Len, Integer::sum);
        }

        for (int num : nums2) {
            frequency.merge(num, nums1Len, Integer::sum);
        }

        int answer = 0;

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                answer = answer ^ entry.getKey();
            }
        }
        return answer;
    }
}
