package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _87_ScrambleString {

    private final Map<String, Boolean> dp = new HashMap<>();

    public static void main(String[] args) {
        _87_ScrambleString obj = new _87_ScrambleString();

        String s1 = "abb", s2 = "bba";
        System.out.println(obj.isScramble(s1, s2));
    }

    /*
        Approach:
        for each length of string, compare first half of first string with first half of second and second half of
        first string with second half of second string

        Since after split, strings can be joined by reverse order as well, so
        also compare, first half of first string with second half of second and second half of
        first string with first half of second string
     */
    public boolean isScramble(String s1, String s2) {

        String key = s1 + "/" + s2;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] charCount = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i)-'a']++;
            charCount[s2.charAt(i)-'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) {
                return false;
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            //compare first half with first half and second half with second half
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i)))   {
                dp.put(key, true);
                return true;
            }

            //compare first half with second half and vice versa
            if (isScramble(s1.substring(0, i), s2.substring(s2.length()-i)) &&
                    isScramble(s1.substring(i), s2.substring(0, s2.length()-i)))   {
                dp.put(key, true);
                return true;
            }
        }
        dp.put(key, false);
        return false;
    }
}
