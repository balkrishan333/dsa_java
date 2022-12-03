package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class _451_SortCharactersByFrequency {

    public static void main(String[] args) {
        _451_SortCharactersByFrequency obj = new _451_SortCharactersByFrequency();

        String s = "tree";
        System.out.println(obj.frequencySort(s));
    }

    public String frequencySort(String s) {
        Map<Character, StringBuilder> charCount = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (charCount.containsKey(ch)) {
                charCount.get(ch).append(ch);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(ch);
                charCount.put(ch, sb);
            }
        }

        List<String> values = new ArrayList<>(charCount.values().stream().map(StringBuilder::toString).toList());
        values.sort(Comparator.comparingInt(String::length).reversed());

        StringBuilder result = new StringBuilder();
        for (String str : values) {
            result.append(str);
        }
        return result.toString();
    }
}
