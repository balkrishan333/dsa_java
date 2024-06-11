package leetcode;

import java.util.*;

public class _1122_RelativeSortArray {

    public static void main(String[] args) {
        _1122_RelativeSortArray obj = new _1122_RelativeSortArray();

        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        System.out.println(Arrays.toString(obj.relativeSortArray(arr1, arr2)));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> count = new LinkedHashMap<>();
        List<Integer> remaining = new ArrayList<>();

        for (int num : arr2) {
            count.put(num, 0);
        }

        for (int num : arr1) {
            if (count.containsKey(num)) {
                count.merge(num, 1, Integer::sum);
            } else {
                remaining.add(num);
            }
        }
        Collections.sort(remaining);
        List<Integer> result = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(entry.getKey());
            }
        }
        result.addAll(remaining);

        return  result.stream().mapToInt(Integer::intValue).toArray();
    }
}
