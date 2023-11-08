package leetcode;

public class _2849_DetermineIfACellIsReachableAtAGivenTime {

    public static void main(String[] args) {
        _2849_DetermineIfACellIsReachableAtAGivenTime obj = new _2849_DetermineIfACellIsReachableAtAGivenTime();

        int sx = 2, sy = 4, fx = 7, fy = 7, t = 6;
        System.out.println(obj.isReachableAtTime(sx,sy,fx,fy,t));
    }

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int width = Math.abs(sx - fx);
        int height = Math.abs(sy - fy);

        if (width == 0 && height == 0 && t == 1) {
            return false;
        }

        return Math.max(width, height) <= t;
    }

}
