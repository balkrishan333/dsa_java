package leetcode;

import java.util.Arrays;

public class _1626_BestTeamWithNoConflicts {

    public static void main(String[] args) {
        _1626_BestTeamWithNoConflicts obj = new _1626_BestTeamWithNoConflicts();

        int[] scores = {4,5,6,5};
        int[] ages = {2,1,2,1};
        System.out.println(obj.bestTeamScore(scores, ages));
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] ageScorePair = new int[scores.length][2];

        //merge age and score ina single array 0-> age, 1-> score
        for (int i = 0; i < scores.length; i++) {
            ageScorePair[i][0] = ages[i];
            ageScorePair[i][1] = scores[i];
        }

        //sort by age and then by score
        Arrays.sort(ageScorePair, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int[] dp = new int[scores.length];
        int max = 0;

        //initialize the dp to players initial score and use max as answer
        for (int i = 0; i < scores.length; i++) {
            dp[i] = ageScorePair[i][1];
            max = Math.max(max, dp[i]);
        }

        for (int i = 1; i < dp.length; i++) {
            // move right to left, to see if there is any score larger than current, if you, add that
            // and take max
            for (int j = i - 1; j >= 0; j--) {
                if (ageScorePair[i][1] >= ageScorePair[j][1]) {
                    dp[i] = Math.max(dp[i], ageScorePair[i][1] + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
