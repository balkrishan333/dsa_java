package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _820_ShortEncodingOfWords {

    public static void main(String[] args) {
        _820_ShortEncodingOfWords obj = new _820_ShortEncodingOfWords();

        String[] words = {"time","me","bell"};
        System.out.println(obj.minimumLengthEncoding(words));
    }

    public int minimumLengthEncoding(String[] words) {

        //Remove duplicates from list
        Set<String> strings = new HashSet<>(Arrays.asList(words));

        //for each string check if any of its string exists in set, if yes remove it
        //start from 1st character otherwise this string itself will be removed.
        for (String word : words) {
            for (int j = 1; j < word.length(); ++j) {
                strings.remove(word.substring(j));
            }
        }

        //no. of hashes will be equal to no of words.
        int result = strings.size();

        for (String str : strings) {
            //result = no of hashes + size of each word
            result += str.length();
        }
        return result;
    }
}
