package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _345_ReverseVowelsOfAString {

    private static final Set<Character> VOWELS = new HashSet<>();

    static {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
        VOWELS.add('A');
        VOWELS.add('E');
        VOWELS.add('I');
        VOWELS.add('O');
        VOWELS.add('U');
    }


    public static void main(String[] args) {
        _345_ReverseVowelsOfAString obj = new _345_ReverseVowelsOfAString();

        String s = "hello";
        System.out.println(obj.reverseVowels(s));
    }

    public String reverseVowels(String s) {

        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length()-1;

        while (start < end) {
            if (VOWELS.contains(chars[start]) && VOWELS.contains(chars[end])) {
                char temp = chars[end];
                chars[end] = chars[start];
                chars[start] = temp;

                start++;
                end--;
            } else if (VOWELS.contains(chars[start])) {
                end--;
            } else if (VOWELS.contains(chars[end])) {
                start++;
            } else {
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}
