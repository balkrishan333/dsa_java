package leetcode;

public class _1266_MinimumTimeVisitingAllPoints {

    public static void main(String[] args) {
        _1266_MinimumTimeVisitingAllPoints obj =
                new _1266_MinimumTimeVisitingAllPoints();

        int[][] points = {{1,1},{3,4},{-1,0}};
        System.out.println(obj.minTimeToVisitAllPoints(points));
    }

    /*
        Approach:

        Move as much diagonally as possible as diagonal movement covers 1 horizontal and 1 vertical move in same time unit.
        Move diagonally until, we line up with either target X or target Y
        Applying following formula gives the number of moves

        Math.max(Math.abs(currX-targetX), Math.abs(currY-targetY));
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length-1; i++) {
            int currX = points[i][0];
            int currY = points[i][1];

            int targetX = points[i+1][0];
            int targetY = points[i+1][1];

            ans += Math.max(Math.abs(currX-targetX), Math.abs(currY-targetY));
        }
        return ans;
    }
}
