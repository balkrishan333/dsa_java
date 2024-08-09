package leetcode;

public class _840_MagicSquaresInGrid {

    public static void main(String[] args) {
        _840_MagicSquaresInGrid obj = new _840_MagicSquaresInGrid();

        int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        System.out.println(obj.numMagicSquaresInside(grid));
    }

    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int answer = 0;
        for (int row = 0; row+2 < rows; row++) {
            for (int col = 0; col+2 < cols; col++) {
                if (isMagicGrid(grid, row, col)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private boolean isMagicGrid(int[][] grid, int row, int col) {
        boolean[] seenNums = new boolean[10];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row+i][col+j];

                if (num < 1 || num > 9) {
                    return false;
                }

                if (seenNums[num]) {
                    return false;
                }
                seenNums[num] = true;
            }
        }

        int diagonal1 = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2];
        int diagonal2 = grid[row+2][col] + grid[row+1][col+1] + grid[row][col+2];

        if (diagonal1 != diagonal2) {
            return false;
        }

        int row1 = grid[row][col] + grid[row][col+1] + grid[row][col+2];
        int row2 = grid[row+1][col] + grid[row+1][col+1] + grid[row+1][col+2];
        int row3 = grid[row+2][col] + grid[row+2][col+1] + grid[row+2][col+2];

        if (row1 != diagonal1 || row2 != diagonal1 || row3 != diagonal1) {
            return false;
        }

        int col1 = grid[row][col] + grid[row+1][col] + grid[row+2][col];
        int col2 = grid[row][col+1] + grid[row+1][col+1] + grid[row+2][col+1];
        int col3 = grid[row][col+2] + grid[row+1][col+2] + grid[row+2][col+2];

        return col1 == diagonal1 && col2 == diagonal1 && col3 == diagonal1;
    }
}
