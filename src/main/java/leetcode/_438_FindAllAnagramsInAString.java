package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _438_FindAllAnagramsInAString {

    public static void main(String[] args) {
        _438_FindAllAnagramsInAString obj = new _438_FindAllAnagramsInAString();

        String s = "baa";
        String p = "aa";
        System.out.println(obj.findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }

        int[] charsP = new int[26];
        int[] charsS = new int[26];

        List<Integer> answer = new ArrayList<>();

        //count no. of characters in both strings, iterate equal to length of shorter string
        for (int i = 0; i < p.length(); i++) {
            charsP[p.charAt(i)-'a']++;
            charsS[s.charAt(i)-'a']++;
        }

        //if character count is equal, add the index
        if (countEqual(charsP, charsS)) {
            answer.add(0);
        }

        //use sliding window, to iterate over rest of string s
        for (int i = p.length(); i <s.length() ; i++) {
            charsS[s.charAt(i)-'a']++;  // increase count of incoming characters
            charsS[s.charAt(i-p.length())-'a']--; // decrease count of outgoing character

            //if char count is equal, add start index
            if (countEqual(charsP, charsS)) {
                answer.add(i-p.length()+1);
            }
        }
        return answer;
    }

    private boolean countEqual(int[] charsP, int[] charsS) {
        for (int i = 0; i < 26; i++) {
            if (charsP[i] != charsS[i]) {
                return false;
            }
        }
        return true;
    }
}
