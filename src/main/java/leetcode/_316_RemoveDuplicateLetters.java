package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _316_RemoveDuplicateLetters {

    public static void main(String[] args) {
        _316_RemoveDuplicateLetters obj = new _316_RemoveDuplicateLetters();

        String s = "bcabc";
        System.out.println(obj.removeDuplicateLetters(s));
    }

    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i)-'a'] = i;
        }

        boolean[] seen = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (seen[curr-'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > curr && i < lastIndex[stack.peek()-'a']) {
                char peek = stack.pop();
                seen[peek-'a'] = false;
            }
            stack.push(curr);
            seen[curr-'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
