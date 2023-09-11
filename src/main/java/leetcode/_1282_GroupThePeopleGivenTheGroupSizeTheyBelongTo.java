package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _1282_GroupThePeopleGivenTheGroupSizeTheyBelongTo {

    public static void main(String[] args) {
        _1282_GroupThePeopleGivenTheGroupSizeTheyBelongTo obj = new _1282_GroupThePeopleGivenTheGroupSizeTheyBelongTo();

        int[] groupSizes = {2,1,3,3,3,2};
        System.out.println(obj.groupThePeople(groupSizes));
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groups = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            groups.computeIfAbsent(groupSizes[i], (j) -> new LinkedList<>()).add(i);
        }

        List<List<Integer>> answer = new LinkedList<>();
        for (Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
            int groupSize = entry.getKey();
            List<Integer> group = new LinkedList<>();
            for (int index : entry.getValue()) {
                if (group.size() == groupSize) {
                    answer.add(group);
                    group = new LinkedList<>();
                }
                group.add(index);
            }
            answer.add(group);
        }

        return answer;
    }
}
