package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class _1219_PathWithMaximumGold {

    public static void main(String[] args) {
        _1219_PathWithMaximumGold obj = new _1219_PathWithMaximumGold();

//        int[][] grid = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(obj.getMaximumGold(grid));
    }

    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxGold = 0;

        // Search for the path with the maximum gold starting from each cell
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                maxGold = Math.max(maxGold, dfsBacktrack(grid, rows, cols, row, col));
            }
        }
        return maxGold;
    }

    private int dfsBacktrack(int[][] grid, int rows, int cols, int row, int col) {
        // Base case: this cell is not in the matrix or this cell has no gold
        if (row < 0 || col < 0 || row == rows || col == cols || grid[row][col] == 0) {
            return 0;
        }
        int maxGold = 0;

        // Mark the cell as visited and save the value
        int originalVal = grid[row][col];
        grid[row][col] = 0;

        // Backtrack in each of the four directions
        for (int[] direction : new int[][]{{0,1},{0,-1},{1,0},{-1,0}}) {
            maxGold = Math.max(maxGold,
                    dfsBacktrack(grid, rows, cols, direction[0] + row,
                            direction[1] + col));
        }

        // Set the cell back to its original value
        grid[row][col] = originalVal;
        return maxGold + originalVal;
    }
}
