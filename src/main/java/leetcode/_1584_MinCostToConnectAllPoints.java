package leetcode;

import java.util.Arrays;

public class _1584_MinCostToConnectAllPoints {

    public static void main(String[] args) {
        _1584_MinCostToConnectAllPoints obj = new _1584_MinCostToConnectAllPoints();

        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(obj.minCostConnectPoints(points));
    }

    public int minCostConnectPoints(int[][] points) {
        int edges = 0;
        int result = 0;
        boolean[] visited = new boolean[points.length];
        int curr = 0;
        visited[curr] = true;
        int[] distArr = new int[points.length];
        Arrays.fill(distArr, Integer.MAX_VALUE);

        while (edges < points.length-1) {
            int next = -1;
            int minEdge = Integer.MAX_VALUE;
            for (int i = 0; i < points.length; i++) {
                if (!visited[i]) {
                    int cost = Math.abs(points[curr][0] - points[i][0]) + Math.abs(points[curr][1] - points[i][1]);
                    distArr[i] = Math.min(cost, distArr[i]);
                    if (distArr[i] < minEdge) {
                        minEdge = distArr[i];
                        next = i;
                    }
                }
            }
            edges++;
            curr = next;
            result += minEdge;
            visited[curr] = true;
        }
        return result;
    }
}
