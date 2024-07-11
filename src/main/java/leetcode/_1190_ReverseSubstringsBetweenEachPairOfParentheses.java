package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1190_ReverseSubstringsBetweenEachPairOfParentheses {

    public static void main(String[] args) {
        _1190_ReverseSubstringsBetweenEachPairOfParentheses obj = new _1190_ReverseSubstringsBetweenEachPairOfParentheses();

        String s = "my(ed(et(oc))el)";
        System.out.println(obj.reverseParentheses(s));
    }

    public String reverseParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar != ')') {
                stack.push(currChar);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); //remove '(' from stack
                for (int j = 0; j < sb.length(); j++) {
                    stack.push(sb.charAt(j));
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return answer.reverse().toString();
    }
}
