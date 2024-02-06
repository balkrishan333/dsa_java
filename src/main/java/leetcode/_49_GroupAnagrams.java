package leetcode;

import java.util.*;

public class _49_GroupAnagrams {

    public static void main(String[] args) {
        _49_GroupAnagrams obj = new _49_GroupAnagrams();

        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(obj.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> groups = new HashMap<>();

        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            groups.putIfAbsent(sorted.hashCode(), new ArrayList<>());
            groups.get(sorted.hashCode()).add(str);
        }
        return new ArrayList<>(groups.values());
    }
}
