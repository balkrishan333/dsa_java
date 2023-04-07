package leetcode;

public class _1020_NumberOfEnclaves {

    public static void main(String[] args) {
        _1020_NumberOfEnclaves obj = new _1020_NumberOfEnclaves();

        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(obj.numEnclaves(grid));
    }

    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Boolean[][] dp = new Boolean[rows][cols];

        int count = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    boolean canExit = dfs(i,j,rows, cols, grid, visited, dp);
                    if (!canExit) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean dfs(int i, int j, int rows, int cols, int[][] grid, boolean[][] visited, Boolean[][] dp) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (i == 0 || i == rows-1 || j ==0 || j == cols-1) {
            dp[i][j] = true;
            return true;
        }

        boolean canExit = false;

        if(!visited[i][j]) {
            visited[i][j] = true;
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] direction : directions) {
                int row = i + direction[0];
                int col = j + direction[1];

                if (grid[row][col] == 1) {
                    canExit = dfs(row, col, rows, cols, grid, visited, dp);
                    dp[row][col] = canExit;
                }
            }
        }
        return canExit;
    }
}
