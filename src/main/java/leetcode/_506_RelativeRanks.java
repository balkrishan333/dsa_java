package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _506_RelativeRanks {

    public static void main(String[] args) {
        _506_RelativeRanks obj = new _506_RelativeRanks();

        int[] score = {10,3,8,9,4};
        System.out.println(Arrays.toString(obj.findRelativeRanks(score)));
    }

    public String[] findRelativeRanks(int[] score) {
        String[] answer = new String[score.length];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));

        for (int i = 0; i < score.length; i++) {
            maxHeap.offer(new int[]{i, score[i]});
        }

        int rank = 1;
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            if (rank == 1) {
                answer[top[0]] = "Gold Medal";
                rank++;
            } else if (rank == 2) {
                answer[top[0]] = "Silver Medal";
                rank++;
            } else if (rank == 3) {
                answer[top[0]] = "Bronze Medal";
                rank++;
            } else {
                answer[top[0]] = String.valueOf(rank++);
            }
        }
        return answer;
    }
}
