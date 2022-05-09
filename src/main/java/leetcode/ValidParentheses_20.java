package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses_20 {

    public static void main(String[] args) {
        ValidParentheses_20 obj = new ValidParentheses_20();

        String s = "()[]{}";
        System.out.println(obj.isValid(s));
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else {
                Character pair = getPair(chars[i]);
                if (pair == null)  {
                    stack.push(chars[i]);
                } else {
                    Character top = stack.pop();
                    if (top != pair) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private Character getPair(char ch) {
        if (ch == '}') {
            return '{';
        }

        if (ch == ']') {
            return '[';
        }

        if (ch == ')') {
            return '(';
        }

        return null;
    }
}
