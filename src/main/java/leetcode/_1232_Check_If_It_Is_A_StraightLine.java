package leetcode;

public class _1232_Check_If_It_Is_A_StraightLine {

    public static void main(String[] args) {
        _1232_Check_If_It_Is_A_StraightLine obj = new _1232_Check_If_It_Is_A_StraightLine();

        int[][] coordinates = {{0,0},{0,1},{0,-1}};
//        int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        System.out.println(obj.checkStraightLine(coordinates));
    }

    /*
        Approach: Compare delta between the points. If points are in same line then delta between points will be same. If delta between
        points is not same, points are not in same line.

        delta = p2y-p1y / p2x-p1x

        Problem with above equation is, delta x can be zero and hence can fail. So we do following

        Intent:

        p2y-p1y        p3y-p1y
        -------   ==   --------
        p2x-p1x        p3x-p1x

        Since denominator can be 0, we do cross product and compare them i.e.

        (p2y-p1y) * (p3x-p1x) == (p3y-p1y) * (p2x-p1x)

     */
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }

        int[] p1 = coordinates[0];
        int[] p2 = coordinates[1];

        int deltaX = p2[0] - p1[0];
        int deltaY = p2[1] - p1[1];

        for (int i = 2; i < coordinates.length; i++) {
            int[] p3 = coordinates[i];

            int currDeltaX = p3[0] - p1[0];
            int currDeltaY = p3[1] - p1[1];

            if (deltaX * currDeltaY != deltaY * currDeltaX) {
                return false;
            }
        }
        return true;
    }
}
