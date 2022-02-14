package leetcode;

import java.util.Arrays;

/*
https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/

 */
public class ReverseString {

    public static void main(String[] args) {
        char[] chars = {'b','a','l','a'};
        reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }

    public static void reverseString(char[] s) {
        if(s.length == 1) {
            return;
        }

        reverseStringImpl(s, s[0], 1);
    }

    private static void reverseStringImpl(char[] s, char ch, int index) {
        System.out.println("call ch = " + ch);
        System.out.println("call index = " + index);
        if(index <  s.length) {
            reverseStringImpl(s, s[index], index+1);
        }

        System.out.println("ch = " + ch);
        System.out.println("index = " + index);
        s[s.length-index] = ch;
    }
}
