package leetcode;

import java.util.Arrays;

public class _3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        _3_LongestSubstringWithoutRepeatingCharacters obj = new _3_LongestSubstringWithoutRepeatingCharacters();

        String s = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] symbols = new int[255];
        int start = 0, length =0;
        Arrays.fill(symbols, -1);

        for(int i =0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = symbols[ch];

            if (index != -1) {
                if(index >= start) {
                    length = Math.max(length, i-start);
                    start = index+1;
                }
            }
            symbols[ch] = i;
        }

        length = Math.max(length, s.length()-start);

        return length;
    }
}
