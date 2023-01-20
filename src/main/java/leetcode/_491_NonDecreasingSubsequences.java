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
        if (index == nums.length) {
            if (sequence.size() > 1) {
                answer.add(new ArrayList<>(sequence));
            }

            return;
        }

        if (sequence.isEmpty() || sequence.get(sequence.size()-1) <= nums[index]) {
            sequence.add(nums[index]);
            backTrack(index+1, sequence, answer, nums);

            sequence.remove(sequence.size()-1);
        }
        backTrack(index+1, sequence, answer, nums);

    }
}
