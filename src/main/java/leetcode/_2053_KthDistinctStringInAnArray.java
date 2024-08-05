package leetcode;

import java.util.*;

public class _2053_KthDistinctStringInAnArray {

    public static void main(String[] args) {
        _2053_KthDistinctStringInAnArray obj = new _2053_KthDistinctStringInAnArray();

        String[] arr = {"d", "b", "c", "b", "c", "a"};
        int k = 2;
        System.out.println(obj.kthDistinct(arr, k));
    }

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String str : arr) {
            map.merge(str, 1, Integer::sum);
        }

        List<String> list = map.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).toList();

        if (list.size() < k) {
            return "";
        }
        return list.get(k - 1);
    }
}
