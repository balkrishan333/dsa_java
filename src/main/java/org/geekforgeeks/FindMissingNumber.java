package org.geekforgeeks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://practice.geeksforgeeks.org/problems/missing-number-in-array/0
 */
public class FindMissingNumber {

    private static final Logger logger = LoggerFactory.getLogger(FindMissingNumber.class);

    public static void main(String[] args) throws Exception {
        FindMissingNumber missingNumber = new FindMissingNumber();
        int[][] arrayList = readInput();

        for (int i = 0 ; i < arrayList.length ; i++) {
            int[] arr = arrayList[i];
            int number = missingNumber.find(arr, arr.length);
            logger.info("Missing number : " + number);
        }
    }

    int find(final int[] arr, final int size) {
        int sum = Arrays.stream(arr).sum();
        logger.info("sum of given numbers : " + sum);

        return (size * (size+1)/2) - sum;
    }

    private static int[][] readInput() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testsCount = Integer.parseInt(reader.readLine());

        int[][] inArrayList = new int[testsCount][];

        for (int i = 0 ; i < testsCount ; i++) {
            String line_1 = reader.readLine();
            String line_2 = reader.readLine();

            String[] line_2_split = line_2.split(" ");

            int inArraySize = Integer.parseInt(line_1);

            int[] inArray = new int[inArraySize];
            for (int ii = 0; ii < line_2_split.length ; ii++) {
                inArray[ii] = Integer.parseInt(line_2_split[ii]);
            }

            inArrayList[i] = inArray;
        }
        return inArrayList;
    }


}
