package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _491_NonDecreasingSubsequences {

    public static void main(String[] args) {
        _491_NonDecreasingSubsequences obj = new _491_NonDecreasingSubsequences();

        int[] nums = {4,6,7,7};
        System.out.println(obj.findSubsequences(nums));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();
        List<Integer> sequence = new ArrayList<>();

        backTrack(0, sequence, answer, nums);

        return new ArrayList<>(answer);
    }

    private void backTrack(int index, List<Integer> sequence, Set<List<Integer>> answer, int[] nums) {
        //base condition for recursion. No room to move ahead from last index
        if (index == nums.length) {
            //add to answer iff size of sequence is at least 2
            if (sequence.size() >= 2) {
                answer.add(new ArrayList<>(sequence));
            }
            return;
        }

        /*
            if current element is greater than last element in sequence, sequence is incrementing,
            so add the element to sequence and move to next index
         */
        if (sequence.isEmpty() || sequence.get(sequence.size()-1) <= nums[index]) {
            sequence.add(nums[index]);
            backTrack(index+1, sequence, answer, nums);

            //remove from sequence for next index
            sequence.remove(sequence.size()-1);
        }

        backTrack(index+1, sequence, answer, nums);

    }
}
