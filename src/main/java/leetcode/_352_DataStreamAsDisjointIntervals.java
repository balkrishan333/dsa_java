package leetcode;

import java.util.*;

public class _352_DataStreamAsDisjointIntervals {

    //use set even if there can be duplicate values because after intervals are created duplicates are removed
    private final Set<Integer> values = new TreeSet<>();

    public static void main(String[] args) {
        _352_DataStreamAsDisjointIntervals obj = new _352_DataStreamAsDisjointIntervals();

        obj.addNum(1);      // arr = [1]
        System.out.println(Arrays.deepToString(obj.getIntervals())); // return [[1, 1]]
        obj.addNum(3);      // arr = [1, 3]
        System.out.println(Arrays.deepToString(obj.getIntervals())); // return [[1, 1], [3, 3]]
        obj.addNum(7);      // arr = [1, 3, 7]
        System.out.println(Arrays.deepToString(obj.getIntervals())); // return [[1, 1], [3, 3], [7, 7]]
        obj.addNum(2);      // arr = [1, 2, 3, 7]
        System.out.println(Arrays.deepToString(obj.getIntervals())); // return [[1, 3], [7, 7]]
        obj.addNum(6);      // arr = [1, 2, 3, 6, 7]
        System.out.println(Arrays.deepToString(obj.getIntervals())); // return [[1, 3], [6, 7]]
    }

    public _352_DataStreamAsDisjointIntervals() {
    }

    public void addNum(int value) {
        values.add(value);
    }

    public int[][] getIntervals() {

        if (values.isEmpty()) {
            return new int[][]{};
        }

        List<int[]> intervals = new ArrayList<>();

        int left = -1, right = -1;
        for (Integer value : values) { // values will be retrieved in sorted order
            
            if (left < 0) {
                //first value in list
                left = right = value;
            } else if (value == right+1) {
                //if incoming value is 1 more than last value, continue the range
                right = value;
            } else {
                //add a new interval if last can't be used
                intervals.add(new int[]{left, right});
                left = right = value; // consume incoming value to create a new interval
            }
        }
        intervals.add(new int[]{left, right});

        return intervals.toArray(new int[0][]);
    }
}
