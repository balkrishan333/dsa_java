package leetcode;

import java.util.Arrays;

public class _3517_SmallestPalindromicRearrangement_I {

    public static void main(String[] args) {
        _3517_SmallestPalindromicRearrangement_I obj =
                new _3517_SmallestPalindromicRearrangement_I();

        String s = "daccad";
        System.out.println(obj.smallestPalindrome(s));
    }

    public String smallestPalindrome(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();

        Arrays.sort(chars, 0, length/2); //sort only first half

        for (int i = 0; i < length/2; i++) {
            chars[length-1-i] = chars[i];
        }
        return new String(chars);
    }
}
