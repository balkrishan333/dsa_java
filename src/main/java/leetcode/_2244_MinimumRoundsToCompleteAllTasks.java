package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _2244_MinimumRoundsToCompleteAllTasks {

    public static void main(String[] args) {
        _2244_MinimumRoundsToCompleteAllTasks obj = new _2244_MinimumRoundsToCompleteAllTasks();

        int[] tasks = {2,2,3,3,2,4,4,4,4,4};
        System.out.println(obj.minimumRounds(tasks));
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int task : tasks) {
            map.merge(task, 1, Integer::sum);
        }

        int rounds = 0;
        for (int size : map.values()) {
            if (size == 1) {
                return -1;
            }
            rounds += (size +2)/3;
        }
        return rounds;
    }
}
