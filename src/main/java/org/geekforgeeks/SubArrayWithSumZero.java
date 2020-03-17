package org.geekforgeeks;

/*
https://practice.geeksforgeeks.org/problems/subarray-with-0-sum/0
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class SubArrayWithSumZero {

    public static void main(String[] args) throws Exception {
        int[][] inputArrList = readInput();

        for(int i = 0 ; i < inputArrList.length ; i++) {
            int[] arr = inputArrList[i];
            SubArrayWithSumZero withSumZero = new SubArrayWithSumZero();
            String result = withSumZero.find(arr);
            System.out.println(result);
        }
    }

    String find(int[] arr) {
        Map<Integer, Boolean> sumTrackMap = new HashMap<>();
        int sum = 0;

        for(int i = 0 ; i < arr.length ; i++) {

            if (arr[i] == 0) {
                return "Yes";
            }

            sum += arr[i];
            if (sumTrackMap.get(sum) != null && sumTrackMap.get(sum)) {
                return "Yes";
            } else {
                sumTrackMap.put(sum, true);
            }
        }
        return sumTrackMap.get(0) != null && sumTrackMap.get(0) ? "Yes" : "No";
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
