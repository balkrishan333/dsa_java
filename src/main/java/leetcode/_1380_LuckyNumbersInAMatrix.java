package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1380_LuckyNumbersInAMatrix {

    public static void main(String[] args) {
        _1380_LuckyNumbersInAMatrix obj = new _1380_LuckyNumbersInAMatrix();

        int[][] matrix = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        System.out.println(obj.luckyNumbers(matrix));
    }

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int min = matrix[i][0];
            int minCol = 0;
            for (int j = 1; j < cols; j++) {
               if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minCol = j;
               }
            }

            if (!seen.contains(minCol)) {
                boolean lucky = true;
                for (int k = 0; k < rows; k++) {
                    if (min <  matrix[k][minCol]) {
                        lucky = false;
                        break;
                    }
                }
                if (lucky) {
                    seen.add(minCol);
                    luckyNumbers.add(min);
                }
            }
        }
        return luckyNumbers;
    }
}
