package leetcode;

import java.util.Arrays;

public class _1751_MaximumNumberOfEventsThatCanBeAttended_II {

    public static void main(String[] args) {
        _1751_MaximumNumberOfEventsThatCanBeAttended_II obj = new _1751_MaximumNumberOfEventsThatCanBeAttended_II();

        int[][] events = {{1, 2, 4}, {3, 4, 3}, {2, 3, 10}};
        int k = 2;
        System.out.println(obj.maxValue(events, k));
    }

    int[][] dp;

    /*
        Approach: Dynamic programming

        Sort the events array and binary search the event which occurs after at the end of current event
     */
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a,b) -> a[0] - b[0]);

        dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findMax(0, k, events);
    }

    private int findMax(int index, int count, int[][] events) {
        if (count == 0 || index >= events.length) {
            return 0;
        }
        if (dp[index][count] != -1) {
            return dp[index][count];
        }

        int nextIndex = binarySearchNextIndex(events, events[index][1]);

        //Usual DP : Either consider one element or leave it and move to next and take max of both situations
        int withoutConsiderCurrElement = findMax(index+1, count, events);
        int withConsideringCurrElement = events[index][2]+ findMax(nextIndex, count-1, events);
        dp[index][count] = Math.max(withoutConsiderCurrElement, withConsideringCurrElement);

        return dp[index][count];

    }
    private int binarySearchNextIndex(int[][] events, int target) {
        int left = 0;
        int right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
