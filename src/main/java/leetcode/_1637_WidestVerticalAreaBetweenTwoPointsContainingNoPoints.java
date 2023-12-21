package leetcode;

import java.util.Arrays;

public class _1637_WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    public static void main(String[] args) {
        _1637_WidestVerticalAreaBetweenTwoPointsContainingNoPoints obj = new _1637_WidestVerticalAreaBetweenTwoPointsContainingNoPoints();

        int[][] points = {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}};
        System.out.println(obj.maxWidthOfVerticalArea(points));
    }

    /*
        Approach: y-axis has no role in deciding the width of area, only x-axis decides that, so ignore y-axis
     */
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] xaxis = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            xaxis[i] = point[0];
        }

        Arrays.sort(xaxis);

        int maxArea = Integer.MIN_VALUE;

        for (int i = 1; i < xaxis.length; i++) {
            maxArea = Math.max(maxArea, xaxis[i] - xaxis[i-1]);
        }
        return maxArea;
    }
}
