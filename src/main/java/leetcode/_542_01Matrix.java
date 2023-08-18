package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class _542_01Matrix {

    public static void main(String[] args) {
        _542_01Matrix obj = new _542_01Matrix();

        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
//        int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(Arrays.deepToString(obj.updateMatrix(mat)));
    }

    private final int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            for (int[] direction : directions) {

                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (nextRow < 0 || nextRow == m || nextCol < 0 || nextCol == n || mat[nextRow][nextCol] != -1) {
                    continue;
                }
                mat[nextRow][nextCol] = mat[row][col] + 1;
                queue.offer(new int[]{nextRow, nextCol});
            }
        }
        return mat;
    }
}
