package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _931_MinimumFallingPathSum {

    public static void main(String[] args) {
        _931_MinimumFallingPathSum obj = new _931_MinimumFallingPathSum();
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(obj.minFallingPathSum(matrix));
    }

    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        for (int i = 0; i < cols; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //take minimum from above row and add current element from matrix
                if (j != 0 && j != cols-1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1]) + matrix[i][j];
                } else if (j == 0) {
                    dp[i][j] = Math.min( dp[i-1][j], dp[i-1][j+1]) + matrix[i][j];
                } else if (j == cols-1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + matrix[i][j];
                }
            }
        }
        return Arrays.stream(dp[rows-1]).min().getAsInt();
    }
}
