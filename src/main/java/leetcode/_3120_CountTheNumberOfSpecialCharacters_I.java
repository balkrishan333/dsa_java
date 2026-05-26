package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _3120_CountTheNumberOfSpecialCharacters_I {

    public static void main(String[] args) {
        _3120_CountTheNumberOfSpecialCharacters_I obj =
                new _3120_CountTheNumberOfSpecialCharacters_I();

        String word = "zZ";
        System.out.println(obj.numberOfSpecialChars(word));
    }

    public int numberOfSpecialChars(String word) {
        Set<Character> charExists = new HashSet<>();

        for (char c : word.toCharArray()) {
            charExists.add(c);
        }

        int count = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            if (charExists.contains(i) && charExists.contains(Character.toUpperCase(i))) {
                count++;
            }
        }
        return count;
    }
}
