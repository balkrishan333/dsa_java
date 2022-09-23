package leetcode;

import java.util.Arrays;

public class _557_ReverseWordsInAStringIII {

    public static void main(String[] args) {
        _557_ReverseWordsInAStringIII obj = new _557_ReverseWordsInAStringIII();

        String s = "Let's take LeetCode contest";
//        String s = "I love u";
        System.out.println(obj.reverseWords(s));
    }

    @SuppressWarnings("unused")
    public String reverseWords_v1(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");

        for (String token : arr) {
            sb.append(new StringBuilder(token).reverse()).append(" ");
        }

        System.out.println(sb.length());
        System.out.println(sb.substring(0, sb.length()-1).length());
        return sb.substring(0, sb.length()); //exclude last space
    }

    public String reverseWords(String s) {

        int startIndex = 0;
        int endIndex = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                endIndex = i-1; // track back one character to leave last space
                if (startIndex == endIndex) { //single character word
                    startIndex = i+1;
                    endIndex = i+1;
                }
            }

            if (i == chars.length-1) {
                endIndex = i; // reached last character in string
            }

            boolean reversed = false;
            while (startIndex < endIndex) {
                char temp = chars[startIndex];
                chars[startIndex] = chars[endIndex];
                chars[endIndex] = temp;

                startIndex++;
                endIndex--;
                reversed = true;
            }

            if (reversed) {
                startIndex = i+1;
                endIndex = i+1;
            }
        }
        return new String(chars);
    }
}
