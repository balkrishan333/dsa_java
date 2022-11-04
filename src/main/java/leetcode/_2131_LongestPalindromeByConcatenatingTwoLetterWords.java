package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _2131_LongestPalindromeByConcatenatingTwoLetterWords {

    public static void main(String[] args) {
        _2131_LongestPalindromeByConcatenatingTwoLetterWords obj = new _2131_LongestPalindromeByConcatenatingTwoLetterWords();

        String[] words = {"lc","cl","gg"};
        System.out.println(obj.longestPalindrome(words));
    }

    public int longestPalindrome(String[] words) {

        Map<String, Integer> wordsCount = new HashMap<>();

        for (String word: words) {
            wordsCount.merge(word, 1, Integer::sum);
        }

        int result = 0;
        boolean center = false;
        for (String word : words) {
            if (wordsCount.containsKey(word)) {
                if (word.charAt(0) == word.charAt(1)) {
                    int count = wordsCount.get(word);
                    if (count % 2 == 0) {
                        result += count;
                    } else {
                        result += count-1;
                        center = true;
                    }
                } else {
                    String reverse = new StringBuilder(word).reverse().toString();
                    if (wordsCount.containsKey(reverse)) {
                        result += (Math.min(wordsCount.get(word), wordsCount.get(reverse))*2);
                    }
                    wordsCount.remove(reverse);
                }
                wordsCount.remove(word);
            }
        }

        if (center) {
            result++;
        }

        return result*2;
    }
}
