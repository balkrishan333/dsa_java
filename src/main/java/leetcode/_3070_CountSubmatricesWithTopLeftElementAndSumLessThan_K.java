package leetcode;

public class _3070_CountSubmatricesWithTopLeftElementAndSumLessThan_K {

    public static void main(String[] args) {
        _3070_CountSubmatricesWithTopLeftElementAndSumLessThan_K obj =
                new _3070_CountSubmatricesWithTopLeftElementAndSumLessThan_K();

        int[][] grid = {{7,6,3},{6,6,1}};
        int k = 18;
        System.out.println(obj.countSubmatrices(grid, k));
    }

    public int countSubmatrices(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > 0) {
                    grid[i][j] += grid[i - 1][j];
                }

                if (j > 0) {
                    grid[i][j] += grid[i][j - 1];
                }

                if (i > 0 && j > 0) {
                    grid[i][j] -= grid[i - 1][j - 1];
                }

                if (grid[i][j] <= k) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
