package leetcode;

public class _3110_ScoreOfAString {

    public static void main(String[] args) {
        _3110_ScoreOfAString obj = new _3110_ScoreOfAString();

        String s = "hello";
        System.out.println(obj.scoreOfString(s));
    }

    public int scoreOfString(String s) {
        int score = 0;
        // Iterate over all indices from 0 to the second-to-last index
        // Calculate and accumulate the absolute difference of ASCII values
        // between adjacent characters
        for (int i = 0; i < s.length() - 1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }
}
