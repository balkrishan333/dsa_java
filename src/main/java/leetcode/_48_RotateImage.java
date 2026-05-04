package leetcode;

import java.util.Arrays;

public class _48_RotateImage {

    public static void main(String[] args) {
        _48_RotateImage obj = new _48_RotateImage();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
                
        obj.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;  //no. of rows

        for(int layer = 0; layer < n/2; layer++) {

            int last = n-1-layer;

            for(int i = layer ; i < last ; i++) {
                int offset = n-1-i;
                //save top
                int top = matrix[layer][i];

                //left -> top
                matrix[layer][i] = matrix[offset][layer];

                //bottom -> left
                matrix[offset][layer] = matrix[last][offset];

                //right -> bottom
                matrix[last][offset] = matrix[i][last];

                //top -> right
                matrix[i][last] = top;
            }
        }
    }
}
