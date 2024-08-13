package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_CombinationSum_II {

    public static void main(String[] args) {
        _40_CombinationSum_II obj = new _40_CombinationSum_II();

        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(obj.combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(answer, temp, candidates, target, 0);
        return answer;
    }

    private void backTrack(List<List<Integer>> answer, List<Integer> temp, int[] candidates, int target, int index) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            answer.add(new ArrayList<>(temp));
        } else {

            //target >= candidates[i] works because array is sorted
            for (int i = index; i < candidates.length && target >= candidates[i]; i++) {

                //following condition avoid duplicate combinations.???
                if (i > index && candidates[i] == candidates[i-1]) {
                    continue;
                }
                temp.add(candidates[i]);
                backTrack(answer, temp, candidates, target-candidates[i], i+1);
                temp.removeLast();
            }
        }
    }
}
