package leetcode;

import java.util.*;

public class _2215_FindTheDifferenceOfTwoArrays {

    public static void main(String[] args) {
        _2215_FindTheDifferenceOfTwoArrays obj = new _2215_FindTheDifferenceOfTwoArrays();

        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,1,2,2};
        System.out.println(obj.findDifference(nums1, nums2));
    }

    /*
        Approach: Use hash table
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        List<List<Integer>> answer = List.of(list1, list2);

        //Add all elements of first array to set
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        //add all elements of 2nd array to set and same time check if element exists in set1. if it does not add it to answer for list2
        Arrays.stream(nums2).distinct().forEach(num -> {
            if(!set1.contains(num)) {
                list2.add(num);
            }
            set2.add(num);
        });

        //check which elements of num1 are not present in num2 and add them to answer
        Arrays.stream(nums1).distinct().forEach(num -> {
            if(!set2.contains(num)) {
                list1.add(num);
            }
        });

        return answer;
    }
}
