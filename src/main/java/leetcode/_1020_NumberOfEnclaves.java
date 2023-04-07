package leetcode;

public class _1020_NumberOfEnclaves {

    public static void main(String[] args) {
        _1020_NumberOfEnclaves obj = new _1020_NumberOfEnclaves();

        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(obj.numEnclaves(grid));
    }

    /*
        Approach: DFS

        Look for all cells in boundary(first row, lasr row, first column, last column) of grid which are labeled 1.
        For each such cell mark call cells which are reachable from this cell using DFS. While marking only visit
        cells which are labeled 1

        Once pre-compute is done, traverse the gird and count all cells which are labeled 1 and are not visisted.
        Cells which are not visited means they were not reachable from any of exits i.e. boundary
     */
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        //First row
        for (int col = 0; col < cols; col++) {
            if (grid[0][col] == 1 && !visited[0][col]) {
                dfs(0, col, rows, cols, grid, visited);
            }
        }

        //last row
        for (int col = 0; col < cols; col++) {
            if (grid[rows-1][col] == 1 && !visited[rows-1][col]) {
                dfs(rows-1, col, rows, cols, grid, visited);
            }
        }

        //first column
        for (int row = 0; row < rows; row++) {
            if (grid[row][0] == 1 && !visited[row][0]) {
                dfs(row, 0, rows, cols, grid, visited);
            }
        }

        //last column
        for (int row = 0; row < rows; row++) {
            if (grid[row][cols-1] == 1 && !visited[row][cols-1]) {
                dfs(row, cols-1, rows, cols, grid, visited);
            }
        }

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, int rows, int cols, int[][] grid, boolean[][] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0 || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        int[][] directions = {{1,0}, {-1,0}, {0, 1}, {0,-1}};

        for (int[] direction : directions) {
            dfs(row + direction[0], col + direction[1], rows, cols, grid, visited);
        }
    }
}
