package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _2116_CheckIfAParenthesesStringCanBeValid {

    public static void main(String[] args) {
        _2116_CheckIfAParenthesesStringCanBeValid obj = new _2116_CheckIfAParenthesesStringCanBeValid();

        String s = "))()))", locked = "010100";
        System.out.println(obj.canBeValid(s, locked));
    }

    public boolean canBeValid(String s, String locked) {

        //with odd length not possible to balance parenthesis
        if (s.length() % 2 == 1) {
            return false;
        }

        Deque<Integer> openBracketStack = new ArrayDeque<>();
        Deque<Integer> unLockedIndexStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            if (locked.charAt(i) == '0') {
                unLockedIndexStack.push(i);
            } else if (s.charAt(i) == '(') {
                openBracketStack.push(i);
            } else if (s.charAt(i) == ')') {
                //find the match for closed bracket either in open bracket or from unlocked chars
                if (!openBracketStack.isEmpty()) {
                    openBracketStack.pop();
                } else if (!unLockedIndexStack.isEmpty()){
                    unLockedIndexStack.pop();
                } else {
                    return false;
                }
            }
        }

        //if there are open brackets left map them with unlocked chars, making sure of sequence (using peek)
        while (!openBracketStack.isEmpty() && !unLockedIndexStack.isEmpty() && openBracketStack.peek() < unLockedIndexStack.peek()) {
            openBracketStack.pop();
            unLockedIndexStack.pop();
        }

        //if there are unmapped open brackets return false
        return openBracketStack.isEmpty();
    }
}
