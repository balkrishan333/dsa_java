package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;

public class _2785_SortVowelsInAString {

    public static void main(String[] args) {
        _2785_SortVowelsInAString obj = new _2785_SortVowelsInAString();

        String s = "lEetcOde";
        System.out.println(obj.sortVowels(s));
    }

    public String sortVowels(String s) {
        Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        PriorityQueue<Character> pq = new PriorityQueue<>();

        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                pq.offer(ch);
            }
        }

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (vowels.contains(chars[i]) && !pq.isEmpty()) {
                chars[i] = pq.poll();
            }
        }
        return new String(chars);
    }
}
