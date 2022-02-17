package crackingcodinginterviewbook.ch1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes_8 {

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};

        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void setZeroes(int[][] matrix) {
        Set<Integer> rowNos = new HashSet<>();
        Set<Integer> colNos = new HashSet<>();

        for (int i = 0; i < matrix.length - 1; i++) {
            if (rowNos.contains(i)) {
                continue;
            }
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (colNos.contains(j)) {
                    continue;
                }
                if (matrix[i][j] == 0) {
                    setCellAndRowToZero(matrix, i,j, rowNos, colNos);
                }

                if (matrix[i+1][j] == 0) {
                    setCellAndRowToZero(matrix, i+1,j, rowNos, colNos);
                }

                if (matrix[i][j+1] == 0) {
                    setCellAndRowToZero(matrix, i,j+1, rowNos, colNos);
                }

                if (matrix[i+1][j+1] == 0) {
                    setCellAndRowToZero(matrix, i+1,j+1, rowNos, colNos);
                }
             }
        }
    }

    private static void setCellAndRowToZero(int[][] matrix, int i, int j, Set<Integer> rowNos, Set<Integer> colNos) {
        rowNos.add(i);
        colNos.add(j);

        for (int k = 0; k < j; k++) {
            matrix[i][k] = 0;
        }

        for (int k = 0; k < j; k++) {
            matrix[i][k] = 0;
        }
    }
}
