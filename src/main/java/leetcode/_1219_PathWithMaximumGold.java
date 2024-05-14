package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class _1219_PathWithMaximumGold {

    public static void main(String[] args) {
        _1219_PathWithMaximumGold obj = new _1219_PathWithMaximumGold();

        int[][] grid = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
        System.out.println(obj.getMaximumGold(grid));
    }

    private int answer = Integer.MIN_VALUE;
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                } else {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int i = top[0];
            int j = top[1];

            if (!visited[i][j]) {
                visited[i][j] = true;
                int curr = traverse(grid, i, j, grid[i][j], visited);
                answer = Math.max(answer, curr);
            }
        }
        return answer;
    }

    private int traverse(int[][] grid, int i, int j, int curr, boolean[][] visited) {
        for (int[] pos : new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}}) {
            int row = i + pos[0];
            int col = j + pos[1];

            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
                if (!visited[row][col]) {
                    curr += grid[row][col];
                    visited[row][col] = true;
                    answer = Math.max(answer, curr);
                    traverse(grid, row, col, curr, visited);
                }
            }
        }
        return curr;
    }
}
