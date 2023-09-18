package leetcode;

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
        int prev = 0;
        int curr = 0;
        visited[curr] = true;

        while (edges < points.length-1) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < points.length; i++) {
                if (!visited[i]) {
                    int cost = Math.abs(points[prev][0] - points[i][0]) + Math.abs(points[prev][1] - points[i][1]);
                    if (cost < min) {
                        min = cost;
                        curr = i;
                    }
                }
            }
            edges++;
            prev = curr;
            result += min;
            visited[curr] = true;
        }
        return result;
    }
}
