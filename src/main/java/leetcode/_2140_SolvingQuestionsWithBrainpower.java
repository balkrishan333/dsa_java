package leetcode;

import java.util.Arrays;

public class _2140_SolvingQuestionsWithBrainpower {

    public static void main(String[] args) {
        _2140_SolvingQuestionsWithBrainpower obj = new _2140_SolvingQuestionsWithBrainpower();

        int[][] questions = {{1,1}, {2,2},{3,3},{4,4},{5,5}};
        System.out.println(obj.mostPoints(questions));
    }

    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);

        return mostPoints(questions, 0, dp);
    }

    /*
        Approach : Dynamic programming

        Take max of (current element + skipping the next n questions) and next question
     */
    private long mostPoints(int[][] questions, int index, long[] dp) {
        if (index >= questions.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int points = questions[index][0];
        int skip = index+ 1 + questions[index][1];
        //Take max of (current + skip) and next
        dp[index] = Math.max((points + mostPoints(questions, skip , dp)), mostPoints(questions, index + 1, dp));

        return dp[index];
    }

    //Recursive Approach - Takes long time
    /*
    private long maxPoints;
    public long mostPoints(int[][] questions) {
        for (int i = 0; i < questions.length; i++) {
            mostPoints_recursive(questions, i);
        }
        return maxPoints;
    }
    private long mostPoints_recursive(int[][] questions, int index) {
        if (index >= questions.length) {
            return 0;
        }

        long points = questions[index][0] + mostPoints_recursive(questions, index+ 1 + questions[index][1]);
        maxPoints = Math.max(maxPoints, points);

        return points;
    }*/
}
