package leetcode;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters_3 {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_3 obj = new LongestSubstringWithoutRepeatingCharacters_3();

        String s = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        char[] chars = s.toCharArray();
        int[] indexs = new int[255];

        Arrays.fill(indexs, -1);
        int length = 0, start = 0, end = -1;

        for (int i = 0; i < chars.length; i++) {
            int index = indexs[chars[i]];

            if (index == -1 || index < start) {
                end++;
            } else {
                // +1 because index are zero based
                int currLength = (i - 1) - start + 1;
                length = Math.max(length, currLength);
                //start from next character which was just found
                start = index + 1;
                end = i;
            }
            indexs[chars[i]] = i;
        }

        // +1 because index are zero based
        length = Math.max(length, end - start + 1);

        return length;
    }
}
