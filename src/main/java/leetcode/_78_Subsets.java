package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _78_Subsets {

    public static void main(String[] args) {
        _78_Subsets obj = new _78_Subsets();

        int[] nums = {1,2,3};
        System.out.println(obj.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> subsets = new HashSet<>();
        subsets.add(new ArrayList<>());
        subsets.add(List.of(nums[0]));

        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : subsets) {
                List<Integer> subset = new ArrayList<>(list);
                subset.add(nums[i]);
                temp.add(subset);
            }
            subsets.addAll(temp);
            subsets.add(List.of(nums[i]));
        }
        return new ArrayList<>(subsets);
    }
}
