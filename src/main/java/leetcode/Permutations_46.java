package leetcode;

import java.util.*;

public class Permutations_46 {

    public static void main(String[] args) {
        Permutations_46 obj = new Permutations_46();

        int[] nums = {1,2,3,4};

        System.out.println(obj.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            List<List<Integer>> result = new ArrayList<>();
            return result;
        }

        if (nums.length == 1) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new LinkedList<>();
            list.add(nums[0]);
            result.add(list);

            return result;
        }

        return doPermute(nums, 0, nums.length-1);
    }

    private List<List<Integer>> doPermute(int[] nums, int start, int end) {
        List<List<Integer>> result;

        if (end - start == 0) {
            result = new LinkedList<>();
            List<Integer> list = new LinkedList<>();
            list.add(nums[start]);
            result.add(list);

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
                List<Integer> l2 = new LinkedList<>();
                l2.addAll(l1);
                l2.add(i, element);
                iterator.add(l2);
            }
        }
        return result;
    }
}
