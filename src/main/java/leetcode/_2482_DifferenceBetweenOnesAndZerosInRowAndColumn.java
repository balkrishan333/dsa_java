package leetcode;

import java.util.Arrays;

public class _2482_DifferenceBetweenOnesAndZerosInRowAndColumn {

    public static void main(String[] args) {
        _2482_DifferenceBetweenOnesAndZerosInRowAndColumn obj = new _2482_DifferenceBetweenOnesAndZerosInRowAndColumn();

        int[][] grid = {
                {0,1,1},{1,0,1},{0,0,1}
        };
        System.out.println(Arrays.deepToString(obj.onesMinusZeros(grid)));
    }

    public int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] rowOneCount = new int[rows];
        int[] rowZeroCount = new int[rows];
        int[] colOneCount = new int[cols];
        int[] colZeroCount = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    rowZeroCount[i]++;
                    colZeroCount[j]++;
                } else {
                    rowOneCount[i]++;
                    colOneCount[j]++;
                }
            }
        }

        int[][] diff = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                diff[i][j] = rowOneCount[i] + colOneCount[j] - rowZeroCount[i] - colZeroCount[j];
            }
        }
        return diff;
    }
}
