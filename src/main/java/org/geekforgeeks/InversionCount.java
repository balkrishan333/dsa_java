package org.geekforgeeks;

/*
https://practice.geeksforgeeks.org/problems/inversion-of-array/0/
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InversionCount {

    private long count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noOfTests = Integer.parseInt(reader.readLine());
        for (int i = 0; i < noOfTests; i++) {

            //read no. of elements
            int elementCount = Integer.parseInt(reader.readLine());
            int[] arr = new int[elementCount];

            //read array elements
            String arrStr = reader.readLine();
            String[] strArr = arrStr.split(" ");
            for (int j = 0; j < strArr.length; j++) {
                arr[j] = Integer.parseInt(strArr[j]);
            }
            InversionCount solution = new InversionCount();
            long swaps = solution.count(arr);
            System.out.println(swaps);
        }
    }

    long count(int[] arr) {
        _countInversion(arr, 0, arr.length-1);
        return count;
    }

    private Range _countInversion(int[] arr, int from, int to) {
        if (from == to) {
          return new Range(from, to);
        }
        int mid = (from + to) /2;
        return merge(arr, _countInversion(arr, from, mid), _countInversion(arr, mid+1, to));
    }

    private Range merge(int[] arr, Range range1, Range range2) {
        int[] arr1 = Arrays.copyOfRange(arr, range1._from, range1._to+1);
        int[] arr2 = Arrays.copyOfRange(arr, range2._from, range2._to+1);

        int i = 0, j = 0;
        int index = range1._from;
        int swap = 0; // track no. of swap in this iteration
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                arr[index++] = arr1[i++];
            } else {
                count += (range2._from + j) - (range1._from + i) - swap++;
                arr[index++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            arr[index++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr[index++] = arr2[j++];
        }
        return new Range(range1._from, range2._to);
    }

    private static class Range {
        private int _from;
        private int _to;

        Range(int from, int to) {
            _from = from;
            _to = to;
        }
    }

    int count_bad(int[] arr) {
        int count = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            for (int j = i+1 ; j < arr.length ; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}


