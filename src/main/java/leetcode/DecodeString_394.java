package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString_394 {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for(int i =0; i < chars.length; i++) {
            if(chars[i] != ']') {
                stack.push(Character.toString(chars[i]));
            } else {
                StringBuilder sb = new StringBuilder();
                while(!stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }
                stack.pop(); //ignore [
                StringBuilder sb2 = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    sb2.insert(0,stack.pop());
                }
                String str = sb.toString();
                int loop = Integer.valueOf(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                for(int j =0 ; j < loop ; j++) {
                    sb3.append(str);
                }
                stack.push(sb3.toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
           sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
