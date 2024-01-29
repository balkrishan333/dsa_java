package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _349_IntersectionOfTwoArrays {

    public static void main(String[] args) {
        _349_IntersectionOfTwoArrays obj = new _349_IntersectionOfTwoArrays();

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(obj.intersection(nums1, nums2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Arrays.stream(nums1).forEach(set1::add);

        Set<Integer> set2 = new HashSet<>();
        Arrays.stream(nums2).forEach(set2::add);

        if (set1.size() < set2.size()) {
            return intersection(set1, set2);
        }
        return intersection(set2, set1);
    }

    private int[] intersection(Set<Integer> set1, Set<Integer> set2) {
        int[] answer = new int[set1.size()];
        int index = 0;
        for (int num : set1) {
            if (set2.contains(num)) {
                answer[index++] = num;
            }
        }
        return Arrays.copyOf(answer, index);
    }
}
