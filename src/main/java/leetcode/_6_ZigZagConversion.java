package leetcode;

import java.util.LinkedList;
import java.util.List;

public class _6_ZigZagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int noRows = 4;

        _6_ZigZagConversion obj = new _6_ZigZagConversion();
        System.out.println(obj.convert(s, noRows));
    }

    public String convert(String s, int numRows) {

        if (s.length() < 2 || numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

        //iterate for each row
        for (int row = 0; row < numRows; row++) {
            //figure out all characters for a row
            //why 2*(numRows-1) works - because after writing a character in row, we need to go to bottom of the column
            //come back up and reach the same row to write next character
            for (int i = row; i < s.length(); i += 2*(numRows-1)) {
                sb.append(chars[i]);

                //except for first and last row, write the character while going up. While going up characters
                //are written from bottom to up
                if (row != 0 && row != numRows-1 && i + 2*(numRows-1) - 2*row < s.length()) {
                    sb.append(chars[i + 2*(numRows-1) - 2*row]);
                }
            }
        }
        return sb.toString();
    }

    public String convert_v1(String s, int numRows) {
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
