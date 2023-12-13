package leetcode;

public class _1582_SpecialPositionsInABinaryMatrix {

    public static void main(String[] args) {
        _1582_SpecialPositionsInABinaryMatrix obj = new _1582_SpecialPositionsInABinaryMatrix();

        int[][] mat = {{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,1},{0,0,0,0,1,0,0,0},{1,0,0,0,1,0,0,0},{0,0,1,1,0,0,0,0}};
        System.out.println(obj.numSpecial(mat));
    }

    /*
        Approach: Pre calculate the number of 1 in each row and column

        Once we have these counts, we iterate over every square and first check if mat[row][col] = 1. If it is, we now check if
        count in that row and column is 1, if yes, this is the special square
     */
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
