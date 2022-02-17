package crackingcodinginterviewbook.ch1;

import java.util.Arrays;

public class RotateImage_7 {

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n-1-layer;
            for(int i = layer ; i < last ; i++) {
                int offset = n-1-i;
                //save top
                int top = matrix[first][i];

                //left -> top
                matrix[first][i] = matrix[offset][first];

                //bottom -> left
                matrix[offset][first] = matrix[last][offset];

                //right -> bottom
                matrix[last][offset] = matrix[i][last];

                //top -> right
                matrix[i][last] = top;
            }
        }
    }
}
