package leetcode;

public class _2328_NumberOfIncreasingPathsInAGrid {

    public static void main(String[] args) {
        _2328_NumberOfIncreasingPathsInAGrid obj = new _2328_NumberOfIncreasingPathsInAGrid();

        int[][] grid = {{1,1},{3,4}};
        System.out.println(obj.countPaths(grid));
    }

    private final int mod = 1000000007;
    private int[][] dp;
    public int countPaths(int[][] grid) {
        int m = grid.length;;
        int n = grid[0].length;

        dp = new int[m][n];

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer = (answer + dfs(grid, i, j)) % mod;
            }
        }
        return answer;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        int count = 1;

        for (int[] direction : new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}}) {
            int prevX = x + direction[0];
            int prevY = y + direction[1];

            if (prevX >= 0 && prevX < grid.length && prevY >= 0 && prevY < grid[0].length && grid[prevX][prevY] < grid[x][y]) {
                count = (count + dfs(grid, prevX, prevY)) % mod;
            }
        }

        dp[x][y] = count;
        return count;
    }
}
