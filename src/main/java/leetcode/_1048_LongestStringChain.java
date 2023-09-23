package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _1048_LongestStringChain {

    public static void main(String[] args) {
        _1048_LongestStringChain obj = new _1048_LongestStringChain();

        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(obj.longestStrChain(words));
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        Map<String, Integer> map = new HashMap<>();
        int result = 1;

        for (String str : words) {
            map.put(str, 1);

            for (int i = 0; i < str.length(); i++) {
                StringBuilder sb = new StringBuilder(str);
                int chain = map.getOrDefault(sb.deleteCharAt(i).toString(), -1);
                if (chain != -1) {
                    chain++;
                    chain = Math.max(map.get(str), chain);
                    map.put(str, chain);
                    result = Math.max(result, chain);
                }
            }
        }
        return result;
    }
}
