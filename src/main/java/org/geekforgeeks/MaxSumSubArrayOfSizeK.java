package org.geekforgeeks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*  https://www.geeksforgeeks.org/maximum-sum-of-k-consecutive-nodes-in-the-given-linked-list/ */

public final class MaxSumSubArrayOfSizeK {

    private static final Logger logger = LoggerFactory.getLogger(MaxSumSubArrayOfSizeK.class);

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testsCount = Integer.parseInt(reader.readLine());

        int[][] inArrayList = new int[testsCount][];
        int[] k_arr = new int[testsCount];

        for (int i = 0 ; i < testsCount ; i++) {
            String line_1 = reader.readLine();
            String line_2 = reader.readLine();

            String[] line_1_split = line_1.split(" ");
            String[] line_2_split = line_2.split(" ");

            int inArraySize = Integer.parseInt(line_1_split[0]);
            int k = Integer.parseInt(line_1_split[1]);

            int[] inArray = new int[inArraySize];
            for (int ii = 0; ii < inArraySize ; ii++) {
                inArray[ii] = Integer.parseInt(line_2_split[ii]);
            }

            inArrayList[i] = inArray;
            k_arr[i] = k;
        }

        for (int i = 0 ; i < testsCount ; i++) {

            int[] inArray = inArrayList[i];
            int k = k_arr[i];

            MaxSumSubArrayOfSizeK arrayOfSizeK = new MaxSumSubArrayOfSizeK();
            logger.info("max sum = " + arrayOfSizeK.maxSum(inArray, k));
            System.out.println(arrayOfSizeK.maxSum(inArray, k));
        }
    }

    int maxSum(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0 ; i <= (arr.length - k) ; i++) {
            int[] subArr = Arrays.copyOfRange(arr, i, i +k);
            int sum = Arrays.stream(subArr).sum();

            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
