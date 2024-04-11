package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _402_RemoveKDigits {

    public static void main(String[] args) {
        _402_RemoveKDigits obj = new _402_RemoveKDigits();

        String num = "10001";
        int k = 1;
        System.out.println(obj.removeKdigits(num, k));
    }

    public String removeKdigits(String num, int k) {

        //base case. if we need to remove all characters, nothing is left so return 0
        if (k == num.length()) {
            return "0";
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        //characters were equal and not enough characters could be removed, so remove the characters
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        builder.reverse();

        int len = builder.length();
        for (int i = 0; i < len; i++) {
            if (builder.charAt(0) == '0') {
                builder.deleteCharAt(0);
            }
        }
        return builder.isEmpty() ? "0" : builder.toString();
    }
}
