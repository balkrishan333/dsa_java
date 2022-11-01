package leetcode;

import java.util.Arrays;

public class _1706_WhereWillTheBallFall {

    public static void main(String[] args) {
        _1706_WhereWillTheBallFall obj = new _1706_WhereWillTheBallFall();

        int[][] grid = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};

        System.out.println(Arrays.toString(obj.findBall(grid)));
    }

    public int[] findBall(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] result = new int[cols];
        Arrays.fill(result, -1);

        int col = 0;
        for (int i = 0; i < cols; i++) {
            col = i;
            int row =0;

            while (row < rows) {
                if (grid[row][col] == 1) {
                    //if last column then hits the wall , if -1 creates a V
                    if (col == cols-1 || grid[row][col+1] == -1) {
                        col = -1;
                        break;
                    } else {
                        //move row and column  ahead
                        row++;
                        col++;
                    }
                } else {
                    //if first column then hits the wall , if 1 creates a V
                    if (col == 0 || grid[row][col - 1] == 1) {
                        col = -1;
                        break;
                    } else {
                        //row always needs to increase as we need to move down, move col back as per direction
                        row++;
                        col--;
                    }
                }
            }
            result[i] = col;
        }
        return result;
    }
}
