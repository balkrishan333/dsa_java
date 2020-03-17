package org.geekforgeeks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
 */
public class SubArrayWithMaxSum {

    private static Logger logger = LoggerFactory.getLogger(SubArrayWithMaxSum.class);

    public static void main(String[] args) throws Exception {
        int[][] arrayList = readInput();

        SubArrayWithMaxSum maxSum = new SubArrayWithMaxSum();
        for (int i = 0 ; i < arrayList.length ; i++) {

            int[] arr = arrayList[i];

            Indexes indexes = maxSum.findSubArray(arr);
//        logger.info("Indexes : " + indexes);

            int sum = Arrays.stream(Arrays.copyOfRange(arr, indexes.getStartIndex(), indexes.getEndIndex() + 1)).sum();
//        logger.info("Result : " + sum);
            System.out.println(sum);
        }
    }

    Indexes findSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE, startIndex = 0, endIndex = 0, currentSumStart = 0;

        int currentSum = 0;
        for (int i =0 ; i < arr.length ; i++) {

            currentSum += arr[i];

            if (maxSum < currentSum) {
                maxSum = currentSum;
                startIndex = currentSumStart;
                endIndex = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                currentSumStart = i+1;
            }
        }
        return new Indexes(startIndex, endIndex);
    }

    static class Indexes {
        private int _startIndex;
        private int _endIndex;

        Indexes(int startIndex, int endIndex) {
            _startIndex = startIndex;
            _endIndex = endIndex;
        }

        int getStartIndex() {
            return _startIndex;
        }

        int getEndIndex() {
            return _endIndex;
        }

        @Override
        public String toString() {
            return "Indexes{" +
                    "_startIndex=" + _startIndex +
                    ", _endIndex=" + _endIndex +
                    '}';
        }
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
            for (int ii = 0; ii < inArraySize ; ii++) {
                inArray[ii] = Integer.parseInt(line_2_split[ii]);
            }

            inArrayList[i] = inArray;
        }
        return inArrayList;
    }
}
