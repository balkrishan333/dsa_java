package leetcode;

import java.util.*;

public class _57_InsertInterval {

    public static void main(String[] args) {
        _57_InsertInterval obj = new _57_InsertInterval();

//        int[][] intervals = {{1, 2}, {6, 7}, {8, 10}, {12, 16}};
//        int[] newInterval = {3,5};

//        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
//        int[] newInterval = {4, 8};

        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2,5};

        System.out.println(Arrays.deepToString(obj.insert(intervals, newInterval)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));

        //step 1: Insert newInterval into list of intervals as correct place
        insertInterval(intervalList, newInterval);

        List<int[]> answer = new ArrayList<>();

        for (int i = 0; i < intervalList.size(); i++) {

            int[] currInterval = intervalList.get(i);

            //step2: merge intervals if they overlap. Check overlap checking logic
            while (i < intervalList.size() && doesIntervalOverlap(currInterval, intervalList.get(i))) {
                currInterval = mergeIntervals(currInterval, intervalList.get(i));
                i++;
            }
            i--;
            answer.add(currInterval);
        }
        return answer.toArray(new int[answer.size()][2]);
    }

    /*
        2 intervals overlap if they have elements in common. in below depiction, common number are between
        b1 and a2 i.e. min of points and max of start points

        a1----------------a2
              b1----------------b2
     */
    private boolean doesIntervalOverlap(int[] interval, int[] interval1) {
        return Math.min(interval[1], interval1[1]) - Math.max(interval[0], interval1[0]) >= 0;
    }

    private int[] mergeIntervals(int[] interval, int[] interval1) {
        return new int[]{ Math.min(interval[0], interval1[0]), Math.max(interval[1], interval1[1])};
    }

    private void insertInterval(List<int[]> intervals, int[] newInterval) {

        boolean inserted = false;
        for (int i =0; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);

            if (newInterval[0] < interval[0]) {
                intervals.add(i, newInterval);
                inserted = true;
                break;
            }
        }

        if (!inserted) {
            intervals.add(newInterval);
        }
    }
}
