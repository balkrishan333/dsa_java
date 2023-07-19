package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _435_NonOverlappingIntervals {

    public static void main(String[] args) {
        _435_NonOverlappingIntervals obj = new _435_NonOverlappingIntervals();

        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(obj.eraseOverlapIntervals(intervals));
    }

    /*
        Approach: Sort the arrays on end time and keep track of current end time as we iterate over elements

        Iterate over array, if the start time of current element is less than curr end time, it is an overlap, exclude it else update the
         end time with curr element end time.
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int answer = 0;
        int currEndTime = Integer.MIN_VALUE;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= currEndTime) {
                currEndTime = intervals[i][1];
            } else {
                answer++;
            }
        }
        return answer;
    }
}
