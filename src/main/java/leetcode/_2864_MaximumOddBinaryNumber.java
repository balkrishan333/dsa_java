package leetcode;

import java.util.stream.Stream;

public class _2864_MaximumOddBinaryNumber {

    public static void main(String[] args) {
        _2864_MaximumOddBinaryNumber obj = new _2864_MaximumOddBinaryNumber();

        String s = "010";
        System.out.println(obj.maximumOddBinaryNumber(s));
    }

    public String maximumOddBinaryNumber(String s) {
        Stream<Character> stream = s.chars().mapToObj(i -> (char)i);
        long noOfOnes = stream.filter(ch -> ch == '1').count();

        StringBuilder builder = new StringBuilder();

        //append all but 1, 1's at start to maximize the number
        for (int i = 0; i < noOfOnes-1; i++) {
            builder.append("1");
        }

        for (int i = 0; i < s.length()-noOfOnes; i++) {
            builder.append("0");
        }
        builder.append("1"); //append 1 at the end, to make number odd
        return builder.toString();
    }
}
