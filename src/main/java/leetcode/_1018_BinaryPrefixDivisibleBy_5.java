package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1018_BinaryPrefixDivisibleBy_5 {

    public static void main(String[] args) {
        _1018_BinaryPrefixDivisibleBy_5 obj =
                new _1018_BinaryPrefixDivisibleBy_5();

        int[] nums = {1,1,1};
        System.out.println(obj.prefixesDivBy5(nums));
    }

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<>();
        int prefix = 0;
        for (int num : nums) {
            prefix = ((prefix << 1) + num) % 5;
            answer.add(prefix == 0);
        }
        return answer;
    }
}
