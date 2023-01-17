package leetcode;

import java.util.*;

public class _350_IntersectionOfArrays_II {

    public static void main(String[] args) {
        _350_IntersectionOfArrays_II obj = new _350_IntersectionOfArrays_II();

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(obj.intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums1) {
            map.merge(num, 1, Integer::sum);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.merge(num, -1, Integer::sum);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
