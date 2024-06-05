package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1002_FindCommonCharacters {

    public static void main(String[] args) {
        _1002_FindCommonCharacters obj = new _1002_FindCommonCharacters();

        String[] words = {"bella","label","roller"};
        System.out.println(obj.commonChars(words));
    }

    public List<String> commonChars(String[] words) {

        int[] commonCharCount = new int[26];
        int[] currentCharCount = new int[26];

        for (char ch : words[0].toCharArray()) {
            commonCharCount[ch-'a']++;
        }

        for (int i = 1; i < words.length; i++) {

            Arrays.fill(currentCharCount, 0);

            for (char ch : words[i].toCharArray()) {
                currentCharCount[ch-'a']++;
            }

            for (int j = 0; j < 26; j++) {
                commonCharCount[j] = Math.min(commonCharCount[j], currentCharCount[j]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < commonCharCount[i]; j++) {
                result.add(Character.toString(i+'a'));
            }
        }
        return result;
    }
}
