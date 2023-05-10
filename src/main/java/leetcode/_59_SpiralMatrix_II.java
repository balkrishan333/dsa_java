package leetcode;

import java.util.Arrays;

public class _59_SpiralMatrix_II {

    public static void main(String[] args) {
        _59_SpiralMatrix_II obj = new _59_SpiralMatrix_II();

        int n = 3;
        System.out.println(Arrays.deepToString(obj.generateMatrix(n)));
    }

    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        int square = n*n;
        int num = 1;
        int rowStart = 0, rowEnd = n-1, colStart = 0, colEnd = n-1;
        while (num <= square) {

            //go right
            for (int i = colStart; i <= colEnd; i++) {
                answer[rowStart][i] = num++;
            }
            rowStart++;

            //go down
            for (int i = rowStart; i <= rowEnd; i++) {
                answer[i][colEnd] = num++;
            }
            colEnd--;

            //go right
            for (int i = colEnd; i >= colStart; i--) {
                answer[rowEnd][i] = num++;
            }
            rowEnd--;

            //go up
            for (int i = rowEnd; i >= rowStart ; i--) {
                answer[i][colStart] = num++;
            }
            colStart++;
        }
        return answer;
    }
}
