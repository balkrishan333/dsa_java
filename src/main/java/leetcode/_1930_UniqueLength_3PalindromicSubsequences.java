package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _1930_UniqueLength_3PalindromicSubsequences {

    public static void main(String[] args) {
        _1930_UniqueLength_3PalindromicSubsequences obj = new _1930_UniqueLength_3PalindromicSubsequences();

        String s = "bbcbaba";
        System.out.println(obj.countPalindromicSubsequence(s));
    }

    public int countPalindromicSubsequence(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char ch : s.toCharArray()) {
            uniqueChars.add(ch);
        }

        int answer = 0;
        //For each character find its first and last index
        for (Character ch : uniqueChars) {
            int i = -1, j = -1;

            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == ch) {
                    if (i == -1) {
                        i = k;
                    } else {
                        j = k;
                    }
                }
            }

            Set<Character> between = new HashSet<>();
            for (int k = i+1; k < j; k++) {
                between.add(s.charAt(k));
            }
            answer += between.size();
        }
        return answer;
    }
}
