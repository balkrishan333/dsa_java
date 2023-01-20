package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _54_SpiralMatrix {

    public static void main(String[] args) {
        _54_SpiralMatrix obj = new _54_SpiralMatrix();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(obj.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rowStart=0,rowEnd= matrix.length-1,colStart=0,colEnd=matrix[0].length-1;

        while (rowStart <= rowEnd && colStart <= colEnd) {

            //go right
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            //go down
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                //go left
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if (colStart <= colEnd) {
                //go up
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;

        }
        return result;
    }
}
