package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _149_MaxPointsOnALine {

    public static void main(String[] args) {
        _149_MaxPointsOnALine obj = new _149_MaxPointsOnALine();

//        int[][] points = {{1,1},{2,2},{3,3}};
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(obj.maxPoints(points));
    }

    /*
    public int maxPoints(int[][] points) {
        Map<Float, Integer> maxPoints = new HashMap<>();

        int max = 0;
        for (int i = 1; i < points.length-max; i++) {
            int[] prevPoint = points[i];

            int i_max = 0;
            for (int j = i+1; j < points.length; j++) {
                int[] currPoint = points[j];

                float slope = (float)(currPoint[1] - prevPoint[1]) / (currPoint[0] - prevPoint[0]);
                maxPoints.merge(slope, 1, Integer::sum);
                i_max = Math.max(i_max, maxPoints.get(slope));
            }
            maxPoints.clear();
            max = Math.max(max, i_max);
        }

        return max+1;
    }*/

    public int maxPoints(int[][] points) {
        int max=0;

        if (points.length < 2) {
            return points.length;
        }

        for(int[] x:points) {

            //need to check slope of each point with every other point
            Map<Float,Integer> map= new HashMap<>();

            for(int[] y:points) {

                //skip, if comparing point to itself
                if(x==y) {
                    continue;
                }

                float slope;

                //avoid division by 0
                if(y[0]-x[0]==0) {
                    slope = Float.POSITIVE_INFINITY;
                } else {

                    //slope = y-coordinate-diff/x-coordinate-diff
                    slope = (float)(y[1]-x[1])/(y[0]-x[0]);
                }
                map.merge(slope,1, Integer::sum);
                max = Math.max(max, map.get(slope));
            }
        }
        return max+1;
    }
}
