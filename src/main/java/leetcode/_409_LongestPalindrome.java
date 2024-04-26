package leetcode;

import java.util.Arrays;

public class _409_LongestPalindrome {

    public static void main(String[] args) {
        _409_LongestPalindrome obj = new _409_LongestPalindrome();
        String s = "abccccdd";

        System.out.println(obj.longestPalindrome(s));
    }

    public int longestPalindrome(String s) {
        int[] count = new int[52]; // count for both uppercase and lowercase characters

        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                count[ch - 'A']++;
            } else {
                count[ch - 'a' + 26]++;
            }
        }

        int length = 0;
        boolean oddPresent = false;
        for (int val : count) {
            if (val % 2 == 0) {
                length += val;
            } else {
                //consider all odd counts with 1 char less
                length += val - 1;
                oddPresent = true;
            }
        }
        return oddPresent ? length + 1 : length; //add 1 if odd is present as we can have 1 odd character in palindrome
    }
}
