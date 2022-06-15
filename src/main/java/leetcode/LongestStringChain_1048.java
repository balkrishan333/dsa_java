package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain_1048 {

    public static void main(String[] args) {
        LongestStringChain_1048 obj = new LongestStringChain_1048();

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
                Integer chain = map.get(sb.deleteCharAt(i).toString());
                if (chain != null) {
                    chain = Math.max(map.get(str), ++chain);
                    map.put(str, chain);
                    result = Math.max(result, chain);
                }
            }
        }
        return result;
    }
}
