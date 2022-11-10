package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1047_RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        String s = "abbaca";

        _1047_RemoveAllAdjacentDuplicatesInString obj = new _1047_RemoveAllAdjacentDuplicatesInString();
        System.out.println(obj.removeDuplicates(s));
    }

    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else {
                char top = stack.peek();
                if (top == chars[i]) {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
