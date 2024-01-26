package leetcode;

import java.util.Arrays;

public class _576_OutOfBoundaryPaths {

    public static void main(String[] args) {
        _576_OutOfBoundaryPaths obj = new _576_OutOfBoundaryPaths();

        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        System.out.println(obj.findPaths(m,n,maxMove,startRow,startColumn));
    }

    private final int MOD = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] memo = new int[m][n][maxMove+1];

        for (int[][] arr : memo) {
            for (int[] arr1 : arr) {
                Arrays.fill(arr1, -1);
            }
        }
        return findPaths(m,n,maxMove,startRow,startColumn,memo);
    }

    private int findPaths(int m, int n, int maxMove, int startRow, int startColumn, int[][][] memo) {
        if (startRow == m || startRow < 0 || startColumn == n || startColumn < 0) {
            return 1;
        }

        if (maxMove == 0) {
            return 0;
        }

        if (memo[startRow][startColumn][maxMove] != -1) {
            return memo[startRow][startColumn][maxMove];
        }

        memo[startRow][startColumn][maxMove] = (
                        (findPaths(m, n, maxMove - 1, startRow - 1, startColumn, memo) +
                        findPaths(m, n, maxMove - 1, startRow + 1, startColumn, memo)) % MOD +
                        (findPaths(m, n, maxMove - 1, startRow, startColumn - 1, memo) +
                                findPaths(m, n, maxMove - 1, startRow, startColumn + 1, memo)
                        ) % MOD
        ) % MOD;

        return memo[startRow][startColumn][maxMove];
    }
}
