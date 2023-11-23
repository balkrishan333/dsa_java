package leetcode;

import java.util.*;

public class _1630_ArithmeticSubarrays {

    public static void main(String[] args) {
        _1630_ArithmeticSubarrays obj = new _1630_ArithmeticSubarrays();

        int[] nums = {4,6,5,9,3,7};
        int[] l = {0,0,2};
        int[] r = {2,3,5};
        System.out.println(obj.checkArithmeticSubarrays(nums, l, r));
    }

    /*
        Approach:

        If arr were to form an arithmetic sequence, then the difference diff that defines the sequence must be equal to
        (max−min)/n−1  Because min must be the first element of the sequence and max must be the final element of the sequence.
        Thus, if we started at min and iterated to max, we would require n−1 iterations. On each iteration, our value would increase by diff
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> answer = new LinkedList<>();
        for (int i = 0; i < l.length; i++) {
            int[] subArr = Arrays.copyOfRange(nums, l[i], r[i]+1);
            answer.add(check(subArr));
        }
        return answer;
    }

    private boolean check(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>(); //use set to check for existence of element for O(1) operation

        for (int num : arr) {
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        //if following condition is true, return false as we can't have diff with fractional value
        if ((max - min) % (arr.length-1) != 0) {
            return false;
        }

        int diff = (max - min) / (arr.length-1);
        int curr = min + diff; //start with min because we know its already in the array
        while (curr < max) {
            if (!set.contains(curr)) {
                return false;
            }
            curr += diff;
        }
        return true;
    }
}
