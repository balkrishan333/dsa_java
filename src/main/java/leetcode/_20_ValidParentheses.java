package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _20_ValidParentheses {

    public static void main(String[] args) {
        _20_ValidParentheses obj = new _20_ValidParentheses();

        String s = "()[]{}";
        System.out.println(obj.isValid(s));
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            if (stack.isEmpty()) {
                stack.push(aChar);
            } else {
                Character pair = getPair(aChar);
                if (pair == null) {
                    //push to stack if its open parenthesis
                    stack.push(aChar);
                } else {
                    //pop if its closing parenthesis
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
