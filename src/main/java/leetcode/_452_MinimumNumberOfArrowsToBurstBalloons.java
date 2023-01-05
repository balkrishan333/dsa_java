package leetcode;

import java.util.Arrays;

public class _452_MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        _452_MinimumNumberOfArrowsToBurstBalloons obj = new _452_MinimumNumberOfArrowsToBurstBalloons();
//        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};

        System.out.println(obj.findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a,b)-> {
            return Integer.compare(a[1], b[1]);
        });

        int arrows = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];

            if(point[0] > end) {
                arrows++;
                end = point[1];
            }
        }
        return arrows;
    }
}
