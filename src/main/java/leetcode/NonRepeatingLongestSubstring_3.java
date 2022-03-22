package leetcode;

import java.util.Arrays;

public class NonRepeatingLongestSubstring_3 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int len = lengthOfLongestSubstring(s);

        System.out.println("len = " + len);
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] symbols = new int[255];
        int start = 0, length =0;
        Arrays.fill(symbols, -1);

        for(int i =0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = symbols[ch];

            if(index == -1) {
                symbols[ch] = i;
                continue;
            }

            if(index >= start) {
                length = Math.max(length, i-start);
                start = index+1;
            }
            symbols[ch] = i;
        }

        length = Math.max(length, s.length()-start);

        return length;
    }
}
