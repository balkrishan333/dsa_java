package org.geekforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.geeksforgeeks.org/find-subarray-with-given-sum/
 */

public final class SubArrayWithGivenSum {

    private static final Index NOT_FOUND = new Index(-1, -1);

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testsCount = Integer.parseInt(reader.readLine());

        int[][] inArrayList = new int[testsCount][];
        int[] targetSums = new int[testsCount];

        for (int i = 0 ; i < testsCount ; i++) {
            String line_1 = reader.readLine();
            String line_2 = reader.readLine();

            String[] line_1_split = line_1.split(" ");
            String[] line_2_split = line_2.split(" ");

            int inArraySize = Integer.parseInt(line_1_split[0]);
            int targetSum = Integer.parseInt(line_1_split[1]);

            int[] inArray = new int[inArraySize];
            for (int ii = 0; ii < inArraySize ; ii++) {
                inArray[ii] = Integer.parseInt(line_2_split[ii]);
            }

            inArrayList[i] = inArray;
            targetSums[i] = targetSum;
        }

        SubArrayWithGivenSum solution = new SubArrayWithGivenSum();
        for (int i = 0 ; i < testsCount ; i++) {

            int[] inArray = inArrayList[i];
            int targetSum = targetSums[i];

            Index index  = solution.findSubArrayWithGivenSum(inArray, targetSum);
            System.out.println(index);
        }

    }

    Index findSubArrayWithGivenSum(int[] inArray, int targetSum) {

        if (inArray == null || inArray.length == 0) {
            return NOT_FOUND;
        }

        int currentSum = 0;
        int startIndex = 0;

        for (int i = 0 ; i < inArray.length ; i++) {
            currentSum += inArray[i];

            if (currentSum == targetSum) {
                return new Index(startIndex+1, i+1);
            }

            if (currentSum > targetSum) { //when sum goes past target
                currentSum = 0; //reset sum and discard current value to calculate next subarray without previous values
                i = startIndex; //start from next index
                startIndex++;
            }
        }
        return NOT_FOUND;
    }

    final static class Index {
        private int _start;
        private int _end;

        Index(int start, int end) {
            _start = start;
            _end = end;
        }

        @Override
        public String toString() {
            if (_start == -1) {
                return String.valueOf(-1);
            }
            return _start + " " + _end;
        }
    }
}
