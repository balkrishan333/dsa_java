package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1544_MakeTheStringGreat {

    public static void main(String[] args) {
        _1544_MakeTheStringGreat obj = new _1544_MakeTheStringGreat();

        String s = "jeSsEJ";
        System.out.println(obj.makeGood(s));
    }

    public String makeGood(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else {
                char top = stack.peek();
                //for any letter, difference between upper case and lower case is 32. Eg: for a, a==97, A==65
                if (Math.abs(top - chars[i]) == 32) {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    /*  When two characters match the criteria, increase the chopIndex to move beyond these characters
        and in process move last character to front in case the last character matches the next incoming character

        Does not work
     */
    public String makeGood_v1(String s) {
        int chopIndex = 0;

        for (int i = 0; i <= s.length() - 2; i++) {
            if ((Character.isLowerCase(s.charAt(i)) && Character.isUpperCase(s.charAt(i+1)) ||
                    Character.isUpperCase(s.charAt(i)) && Character.isLowerCase(s.charAt(i+1)))) {

                if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(i+1))) {
                    chopIndex +=2;
                    if (i > 0) {
                        s = s.replace(s.charAt(i+1), s.charAt(i-1));
                    }
                    i = chopIndex-1;
                }
            }
        }
        return s.substring(chopIndex);
    }
}
