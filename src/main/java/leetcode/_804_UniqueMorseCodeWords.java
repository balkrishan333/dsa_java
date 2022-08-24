package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _804_UniqueMorseCodeWords {

    private static final String[] MORSE_CODES = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
                                                    "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
                                                    "..-","...-",".--","-..-","-.--","--.."
                                                };

    public static void main(String[] args) {
        _804_UniqueMorseCodeWords obj = new _804_UniqueMorseCodeWords();

        String[] words = {"gin","zen","gig","msg"};
        System.out.println(obj.uniqueMorseRepresentations(words));
    }

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> codes = new HashSet<>();

        Arrays.stream(words).forEach(word -> {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                sb.append(MORSE_CODES[word.charAt(i)-97]);
            }
            codes.add(sb.toString());
        });
        return codes.size();
    }
}
