package leetcode;

import java.util.*;

public class _2610_ConvertAnArrayInto_A_2D_ArrayWithConditions {

    public static void main(String[] args) {
        _2610_ConvertAnArrayInto_A_2D_ArrayWithConditions obj = new _2610_ConvertAnArrayInto_A_2D_ArrayWithConditions();

        int[] nums = {1,3,4,1,2,3,1};
        System.out.println(obj.findMatrix(nums));
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new LinkedList<Integer>());

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            int listIndex = map.getOrDefault(num, -1);
            if(listIndex == -1) {
                answer.get(0).add(num); //if element seen first time, add to first list
            } else if(answer.size()-1 > listIndex) {
                answer.get(listIndex+1).add(num);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(num);
                answer.add(list);
            }
            map.put(num, listIndex+1);
        }
        return answer;
    }
}
