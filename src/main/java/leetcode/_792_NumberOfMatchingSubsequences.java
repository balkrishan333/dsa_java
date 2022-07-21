package leetcode;

import java.util.*;

public class _792_NumberOfMatchingSubsequences {

    public static void main(String[] args) {
        _792_NumberOfMatchingSubsequences obj = new _792_NumberOfMatchingSubsequences();
        String s = "abcde"; String[] words = {"a","bb","acd","ace"};

        System.out.println(obj.numMatchingSubseq(s, words));
    }

    /*
        For each word, keep track of character for which the word is waiting. Once we get that character(in string),
        track the work for next character in word. if there are no more characters left in word, count it in.
     */
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;

        //Map to track character for each word
        Map<Character, List<String>> charToStringMap = new HashMap<>();
        for (String word: words) {
            addToMap(charToStringMap, word);
        }

        char[] chars = s.toCharArray();
        for (Character ch :  chars) {
            List<String> wordList = charToStringMap.remove(ch);
            if (wordList != null) {
                Iterator<String> iterator = wordList.iterator();
                while (iterator.hasNext()) {
                    String word = iterator.next();
                    //if no charcaters left in string count it in
                    if (word != null && word.trim().length() == 0) {
                        count++;
                    } else {
                        addToMap(charToStringMap, word);
                    }
                    iterator.remove();
                }
            }
        }
        return count;
    }

    private void addToMap(Map<Character, List<String>> charToStringMap, String word) {
        Character key = word.charAt(0); // first character as key, as we need to track this charcter for this string
        List<String> strList = charToStringMap.computeIfAbsent(key, k -> new ArrayList<>());
        strList.add(word.substring(1)); //put rest of the string as value

    }
}
