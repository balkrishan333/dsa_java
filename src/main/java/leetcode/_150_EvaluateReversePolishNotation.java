package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class _150_EvaluateReversePolishNotation {

    public static void main(String[] args) {
        _150_EvaluateReversePolishNotation obj = new _150_EvaluateReversePolishNotation();

        String[] tokens = {"2","1","+","3","*"};
        System.out.println(obj.evalRPN(tokens));
    }

    private static final Set<String> OPERATORS = Set.of("+", "-", "/", "*");
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (!OPERATORS.contains(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                int result = switch (token) {
                    case "*" -> operand1 * operand2;
                    case "/" -> operand2 / operand1;
                    case "+" -> operand1 + operand2;
                    case "-" -> operand2 - operand1;
                    default -> throw new IllegalStateException("Unexpected value: " + token);
                };
                stack.push(result);
            }
        }
        return stack.pop();
    }
}
