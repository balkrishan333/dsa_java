package leetcode;

import java.util.Arrays;

public class _452_MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        _452_MinimumNumberOfArrowsToBurstBalloons obj = new _452_MinimumNumberOfArrowsToBurstBalloons();
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};

        System.out.println(obj.findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a,b)-> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        //use sliding window to find overlapping items
        for (int i = 0, j=i+1; i < points.length && j < points.length; i++) {
            int[] point = points[i];
            int[] nextPoint = points[j];

            if ((point[0] >= nextPoint[0] && point[0] <= nextPoint[1]) ||
                    (point[1] <= nextPoint[1] && point[1] >= nextPoint[0])) {

                System.out.println(Arrays.toString(point) + " and " + Arrays.toString(nextPoint) + " overlap.");
            }
        }
        return 0;
    }
}
