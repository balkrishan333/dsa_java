package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _946_ValidateStackSequences {

    public static void main(String[] args) {
        _946_ValidateStackSequences obj = new _946_ValidateStackSequences();

        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(obj.validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();

        int popIndex = 0;
        for (int j : pushed) {
            stack.push(j);

            while (popIndex < popped.length && !stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return popIndex == popped.length;
    }
}
