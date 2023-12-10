package leetcode;

import java.util.Arrays;

public class _867_TransposeMatrix {

    public static void main(String[] args) {
        _867_TransposeMatrix obj = new _867_TransposeMatrix();

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(obj.transpose(matrix)));
    }

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //if no of rows and cols are unequals swap rows and cols
        if(m != n) {
            int[][] result = new int[n][m];
            for(int i =0; i < n; i++) {
                for(int j =0; j < m; j++) {
                    result[i][j] = matrix[j][i];
                }
            }
            return result;
        } else {
            //leave diagonals as it is
            //work only for i < j otherwise we will end up swapping element twice
            for(int i =0; i < m; i++) {
                for(int j =0; j < n; j++) {
                    if(i < j) {
                        swap(i,j, matrix);
                    }
                }
            }
            return matrix;
        }
    }

    private void swap(int i, int j, int[][] matrix) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
    }
}
