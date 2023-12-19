package leetcode;

import java.util.Arrays;

public class _661_ImageSmoother {

    public static void main(String[] args) {
        _661_ImageSmoother obj = new _661_ImageSmoother();

        int[][] img = {{100,200,100},{200,50,200},{100,200,100}};
        System.out.println(Arrays.deepToString(obj.imageSmoother(img)));
    }

    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;

        int[][] answer = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                int count = 0;

                for (int k = i-1; k <= i+1; k++) {
                    for (int l = j-1; l <= j+1; l++) {

                        if (k >=0 && k < rows && l >= 0 && l < cols) {
                            sum += img[k][l];
                            count++;
                        }

                    }
                }
                answer[i][j] = sum/count;
            }
        }
        return answer;
    }
}
