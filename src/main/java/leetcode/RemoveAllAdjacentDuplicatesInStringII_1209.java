package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicatesInStringII_1209 {

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringII_1209 obj = new RemoveAllAdjacentDuplicatesInStringII_1209();

        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(obj.removeDuplicates(s, k));
    }

    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return s;
        }

        if (k == 1) {
            return "";
        }

        Deque<AdjacentCharCount> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            if (!stack.isEmpty()) {
                AdjacentCharCount cnt = stack.peek();
                if (cnt.ch == ch) {
                    cnt.count++;

                    if (cnt.count == k) {
                        stack.pop();
                    }

                } else {
                    AdjacentCharCount cnt2 = new AdjacentCharCount();
                    cnt2.ch = ch;
                    cnt2.count = 1;

                    stack.push(cnt2);
                }
            } else {
                AdjacentCharCount cnt2 = new AdjacentCharCount();
                cnt2.ch = ch;
                cnt2.count = 1;

                stack.push(cnt2);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            AdjacentCharCount ele = stack.pop();
            for (int i = 0; i < ele.count; i++) {
                sb.append(ele.ch);
            }
        }

        return sb.reverse().toString();
    }

    class AdjacentCharCount {
        char ch;
        int count;
    }
}
