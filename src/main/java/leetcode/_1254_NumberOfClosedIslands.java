package leetcode;

public class _1254_NumberOfClosedIslands {

    public static void main(String[] args) {
        _1254_NumberOfClosedIslands obj = new _1254_NumberOfClosedIslands();

//        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        int[][] grid = {{0,1,1,1,1,1,1,1},{1,0,1,0,0,0,0,1},{1,0,1,0,0,1,0,1},{1,0,0,0,0,1,0,1},{1,0,0,1,0,1,0,1},{1,
                1,0,1,0,0,0,1},{1,0,0,0,0,0,0,1},{0,1,1,1,1,1,1,1}};
        System.out.println(obj.closedIsland(grid));
    }

    /*
        Approach: DFS
        See inline commetns
     */
    public int closedIsland(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0 && !visited[row][col] && dfs(row, col, rows, cols, grid, visited)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean dfs(int row, int col, int rows, int cols, int[][] grid, boolean[][] visited) {
        //if index out of range return false. This mean land cell is at boundary of grid
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }

        //if cell already visited or is water cell (we are checking for water cell for condition to be true) return true
        if (grid[row][col] == 1 || visited[row][col]) {
            return true;
        }

        visited[row][col] = true;
        boolean surroundedByWater = true;

        int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        //check all surrounding cells in 4 directions to see if this cell is all surrounded by water
        for(int[] direction : directions) {
            if (!dfs(row + direction[0], col+direction[1], rows, cols, grid, visited)){
                surroundedByWater = false; //if any of the direction is not surrounded by water, set closed to false
            }
        }
        return surroundedByWater;
    }
}
