package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1717_MaximumScoreFromRemovingSubstrings {

    public static void main(String[] args) {
        _1717_MaximumScoreFromRemovingSubstrings obj = new _1717_MaximumScoreFromRemovingSubstrings();

        String s = "cdbcbbaaabab";
        int x = 4, y = 5;
        System.out.println(obj.maximumGain(s, x, y));
    }

    public int maximumGain(String s, int x, int y) {
        String firstTarget = x > y ? "ab" : "ba";
        String secondTarget = firstTarget.equals("ab") ? "ba" : "ab";

        int totalPoints = 0;
        String afterFirstPass = removePair(s, firstTarget);
        totalPoints += ((s.length() - afterFirstPass.length()) / 2) * (Math.max(x, y));

        String afterSecondPass = removePair(afterFirstPass, secondTarget);
        totalPoints += ((afterFirstPass.length() - afterSecondPass.length()) / 2) * (Math.min(x, y));

        return totalPoints;
    }

    private String removePair(String s , String target) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == target.charAt(1) && !stack.isEmpty() && stack.peek() == target.charAt(0)) {
                stack.pop();
            } else {
                stack.push(curr);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
