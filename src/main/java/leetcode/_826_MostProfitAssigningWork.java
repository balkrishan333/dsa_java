package leetcode;

import java.util.*;

public class _826_MostProfitAssigningWork {

    public static void main(String[] args) {
        _826_MostProfitAssigningWork obj = new _826_MostProfitAssigningWork();

        int[] difficulty = {68,35,52,47,86};
        int[] profit = {67,17,1,81,3};
        int[] worker = {92,10,85,84,82};

        System.out.println(obj.maxProfitAssignment(difficulty, profit, worker));
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;

        int[][] difficultyAndProfit = new int[n][2];
        for (int i = 0; i < n; i++) {
            difficultyAndProfit[i][0] = difficulty[i];
            difficultyAndProfit[i][1] = profit[i];
        }

        //sort by difficulty
        Arrays.sort(difficultyAndProfit, Comparator.comparingInt(arr -> arr[0]));

        //since an array is sorted by difficulty, lower difficultly can have high profit. To account for this, as we move forward, we take
        // max of profit. This is required because we do binary search and once we find a direction, we don't move in another direction. If
        // we start moving towards the end but the higher profit is at the beginning, we will miss that without this.
        for (int i = 0; i < difficultyAndProfit.length - 1; i++) {
            difficultyAndProfit[i + 1][1] = Math.max(difficultyAndProfit[i][1],difficultyAndProfit[i + 1][1]);
        }

        int maxProfit = 0;
        for (int ability : worker) {

            int l = 0, r = difficultyAndProfit.length - 1;
            int jobProfit = 0;

            while (l <= r) {
                int mid = (l + r) / 2;
                if (difficultyAndProfit[mid][0] <= ability) {
                    jobProfit = Math.max(jobProfit, difficultyAndProfit[mid][1]);
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            maxProfit += jobProfit;
        }
        return maxProfit;
    }
}
