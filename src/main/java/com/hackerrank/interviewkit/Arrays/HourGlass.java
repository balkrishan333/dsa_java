package com.hackerrank.interviewkit.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class HourGlass {

    private static Logger logger = LoggerFactory.getLogger(HourGlass.class);

    public static void main(String[] args) {
        int[][] arr = {
                /*{1,1,1,0,0,0},
                {0,1,0,0,0,0},
                {1,1,1,0,0,0},
                {0,0,2,4,4,0},
                {0,0,0,2,0,0},
                {0,0,1,2,4,0}*/
                {-9, -9, -9,  1, 1, 1},
                {0, -9,  0,  4, 3, 2},
                {-9, -9, -9,  1, 2, 3},
                {0,  0,  8,  6, 6, 0},
                {0,  0,  0, -2, 0, 0},
                {0,  0,  1,  2, 4, 0}
        };
        int maxSum = new HourGlass().run(arr);
        logger.info("Sum: {}", maxSum);
    }

    int run(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0 ; i <arr.length-2; i++) {
            for (int j = 0; j < arr[i].length-2; j++) {
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                            arr[i+1][j+1] +
                        arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}
