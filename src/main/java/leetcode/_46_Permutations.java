package leetcode;

import java.util.*;

public class _46_Permutations {

    public static void main(String[] args) {
        _46_Permutations obj = new _46_Permutations();

        int[] nums = {1,2,3,4};

        System.out.println(obj.permute(nums));
    }

    /*
        Approach: BackTracking
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        if (nums.length == 1) {
            result.add(List.of(nums[0]));
            return result;
        }
        return doPermute(nums, 0, nums.length-1);
    }

    private List<List<Integer>> doPermute(int[] nums, int start, int end) {
        List<List<Integer>> result;

        if (end == start) {
            result = new LinkedList<>();
            result.add(List.of(nums[start]));

            return result;
        }

        result = doPermute(nums, start, end-1);

        int element = nums[end];

        ListIterator<List<Integer>> iterator = result.listIterator();
        /*
            From recursive all, we get list and need to insert current element at each position in returned list
            For ex: result contains: [1,2,3]
            now need to insert 4 at each position to make sure we have all possible permutations
         */
        while (iterator.hasNext()) {
            List<Integer> l1 = iterator.next();
            //remove the list from result, as final result should have lists whose size should be same as nums.length
            iterator.remove();

            for (int i = 0; i <= l1.size(); i++) {
                List<Integer> l2 = new LinkedList<>(l1);
                l2.add(i, element);
                iterator.add(l2);
            }
        }
        return result;
    }
}
