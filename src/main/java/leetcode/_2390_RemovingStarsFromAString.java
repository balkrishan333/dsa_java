package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _2390_RemovingStarsFromAString {

    public static void main(String[] args) {
        _2390_RemovingStarsFromAString obj = new _2390_RemovingStarsFromAString();

        String s = "leet**cod*e";
        System.out.println(obj.removeStars(s));
    }

    /*
        Approach: Use stack

        Push character to stack if it is not *. If character is star, pop an element from stack

        Append all elements to string builder and return reverse of it.
     */
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (char ch : chars) {
            if (ch == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
