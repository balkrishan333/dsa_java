package leetcode;

import java.util.Arrays;

public class _2943_MaximizeAreaOfSquareHoleInGrid {

    public static void main(String[] args) {
        _2943_MaximizeAreaOfSquareHoleInGrid obj =
                new _2943_MaximizeAreaOfSquareHoleInGrid();

        int n = 2;
        int m = 1;
        int[] hBars = {2,3};
        int[] vBars = {2};
        System.out.println(obj.maximizeSquareHoleArea(n, m, hBars, vBars));
    }

    /*
        Approach: To create a square, we need to have consecutive cells after removing the bars

        So, we sort the bars and try to find the max consecutive cells from both horizontal and verticals bar
        and then min of those, that will be the size of side.
     */
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int hMax = 1;
        int vMax = 1;
        int hCurr = 1;
        int vCurr = 1;

        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == hBars[i-1]+1) { //check if bars are consecutive
                hCurr++;
            } else {
                hCurr = 1;
            }
            hMax = Math.max(hMax, hCurr);
        }

        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == vBars[i-1]+1) { //check if bars are consecutive
                vCurr++;
            } else {
                vCurr = 1;
            }
            vMax = Math.max(vMax, vCurr);
        }

        int side = Math.min(hMax, vMax) + 1; //+1 because after removing the bars, cells are merged and hence size increases by 1
        return side*side;
    }
}
