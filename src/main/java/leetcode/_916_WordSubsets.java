package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _916_WordSubsets {

    public static void main(String[] args) {
        _916_WordSubsets obj = new _916_WordSubsets();

        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e","o"};

        System.out.println(obj.wordSubsets(words1, words2));
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCountOfEachCharInWords2 = new int[26];

        for (String word :  words2) {
            int[] charCountInCurrWord = new int[26];
            for (int i = 0; i < word.length(); i++) {
                int charAscii = word.charAt(i) - 97;
                charCountInCurrWord[charAscii]++;
            }

            for (int i = 0; i < 26; i++) {
                maxCountOfEachCharInWords2[i] = Math.max(maxCountOfEachCharInWords2[i], charCountInCurrWord[i]);
            }
        }

        List<String> answer = new ArrayList<>();
        for (String word : words1) {
            int[] charCountInCurrWord = new int[26];
            for (int i = 0; i < word.length(); i++) {
                int charAscii = word.charAt(i) - 97;
                charCountInCurrWord[charAscii]++;
            }

            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (charCountInCurrWord[i] < maxCountOfEachCharInWords2[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                answer.add(word);
            }
        }
        return answer;
    }
}
