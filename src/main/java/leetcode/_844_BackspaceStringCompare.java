package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _844_BackspaceStringCompare {

    public static void main(String[] args) {
        _844_BackspaceStringCompare obj = new _844_BackspaceStringCompare();

        String s = "y#fo##f", t = "y#f#o##f";
        System.out.println(obj.backspaceCompare(s, t));
    }

    public boolean backspaceCompare(String s, String t) {
        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();

        createStack(s, stack1);
        createStack(t, stack2);

        if (stack1.size() != stack2.size()) {
            return false;
        }

        while (!stack1.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;
    }

    private void createStack(String s, Deque<Character> stack1) {
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(ch);
            }
        }
    }
}
