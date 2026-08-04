package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _3731_FindMissingElements {

    public static void main(String[] args) {
        _3731_FindMissingElements obj = new _3731_FindMissingElements();

        int[] nums = {5,1};
        System.out.println(obj.findMissingElements(nums));
    }

    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            numSet.add(num);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = min; i <= max ; i++) {
            if (!numSet.contains(i)) {
                answer.add(i);
            }
        }
        return answer;
    }
}
