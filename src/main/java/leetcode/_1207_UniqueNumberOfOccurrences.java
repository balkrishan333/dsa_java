package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1207_UniqueNumberOfOccurrences {

    public static void main(String[] args) {
        _1207_UniqueNumberOfOccurrences obj = new _1207_UniqueNumberOfOccurrences();

        int[] arr = {1,2,2,1,1,3};
        System.out.println(obj.uniqueOccurrences(arr));
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : arr) {
            count.merge(num, 1, Integer::sum);
        }

        Set<Integer> values = new HashSet<>(count.values());
        return count.size() == values.size();
    }
}
