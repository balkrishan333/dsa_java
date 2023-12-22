package leetcode;

public class _1422_MaximumScoreAfterSplittingAString {

    public static void main(String[] args) {
        _1422_MaximumScoreAfterSplittingAString obj = new _1422_MaximumScoreAfterSplittingAString();

        String s = "00";
        System.out.println(obj.maxScore(s));
    }

    public int maxScore(String s) {
        int left, right, passedBy = 0;
        int maxScore = Integer.MIN_VALUE;

        //Since both left and right substrings need to be non-empty, first char will always be in left and last char will always in right
        left = s.charAt(0) == '0' ? 1 : 0;
        right = s.charAt(s.length()-1) == '1' ? 1 : 0;

        //count no of 1 in right
        for (int i = 1; i < s.length()-1; i++) {
            if (s.charAt(i) == '1') {
                right++;
            }
        }
        maxScore = Math.max(maxScore, left+right);

        //Iterate over middle string and try to push each char to left and update score at each step
        for (int i = 1; i < s.length()-1; i++) {
            if (s.charAt(i) == '1') {
                passedBy++; // count no of 1's passed. This will be used when a 0 comes, and we push it to left, then we need to reduce
                // right by passed 1's as these many 1's will from right to left
            } else {
                //if char is 0, adjust all the score because this is the time we can make another split in string
                left++;
                right = right - passedBy;
                passedBy = 0;
            }
            maxScore = Math.max(maxScore, left+right);
        }
        return maxScore;
    }
}
