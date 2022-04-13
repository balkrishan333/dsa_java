package leetcode;

import java.util.LinkedList;
import java.util.List;

public class ZigZagConversion_6 {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int noRows = 4;

        System.out.println(convert_v2(s, noRows));
    }

    public static String convert_v2(String s, int numRows) {

        if (s.length() < 2 || numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

        for (int row = 0; row < numRows; row++) {
            for (int i = row; i < s.length(); i += 2*(numRows-1)) {
                sb.append(chars[i]);

                if (row != 0 && row != numRows-1 && i + 2*(numRows-1) - 2*row < s.length()) {
                    sb.append(chars[i + 2*(numRows-1) - 2*row]);
                }
            }
        }
        return sb.toString();
    }

    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        List<List<Character>> matrix = new LinkedList<>();

        for (int i = 0; i < numRows; i++) {
            matrix.add(new LinkedList<>());
        }

        int i = 0;
        while (i < chars.length) {
            for (int j = 0; j < numRows; j++) {
                if (i >= chars.length) {
                    break;
                }
                matrix.get(j).add(chars[i]);
                i++;
            }

            for (int j = numRows-2; j > 0 ; j--) {
                if (i >= chars.length) {
                    break;
                }
                matrix.get(j).add(chars[i]);
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (List<Character> l1 :  matrix) {
            for (Character ch : l1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
