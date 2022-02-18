package crackingcodinginterviewbook.ch1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes_8 {

    public static void main(String[] args) {
//        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] matrix = {{0,1}};

        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int i = 0; i < cols.length; i++) {
            if (cols[i]) {
                for (int row =0; row < matrix.length; row++) {
                    matrix[row][i]=0;
                }
            }
        }
    }
}
