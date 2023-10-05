package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _229_MajorityElement_II {

    public static void main(String[] args) {
        _229_MajorityElement_II obj = new _229_MajorityElement_II();

        int[] nums = {3,2,3};
        System.out.println(obj.majorityElement(nums));
    }

    public List<Integer> majorityElement(int[] nums) {
        int threshold = (int)Math.floor(nums.length/3);
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }
        List<Integer> answer = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > threshold) {
                answer.add(entry.getKey());
            }
        }
        return answer;
    }
}
