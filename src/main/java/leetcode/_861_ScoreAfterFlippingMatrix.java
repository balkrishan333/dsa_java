package leetcode;

public class _861_ScoreAfterFlippingMatrix {

    public static void main(String[] args) {
        _861_ScoreAfterFlippingMatrix obj = new _861_ScoreAfterFlippingMatrix();

        int[][] grid = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(obj.matrixScore(grid));
    }

    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) { //if first bit of row is 0, flip the row as MSB has more contribution compared to all other bits
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        //since MSB for each row should be 1, start from 2nd column
        for (int j = 1; j < n; j++) {
            int zeroCount = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 0) {
                    zeroCount++;
                }
            }

            if (zeroCount > m - zeroCount) {
                for (int i = 0; i < m; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = grid[i][j] << (n-j-1);
                answer += curr;
            }
        }
        return answer;
    }
}
