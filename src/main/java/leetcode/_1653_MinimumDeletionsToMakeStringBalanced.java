package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1653_MinimumDeletionsToMakeStringBalanced {

    public static void main(String[] args) {
        _1653_MinimumDeletionsToMakeStringBalanced obj = new _1653_MinimumDeletionsToMakeStringBalanced();

        String s = "aababbab";
        System.out.println(obj.minimumDeletions(s));
    }

    public int minimumDeletions(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        int deletions = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == 'b' && s.charAt(i) == 'a') {
                stack.pop();
                deletions++;
            } else {
                stack.push(s.charAt(i));
            }
        }
        return deletions;
    }
}
