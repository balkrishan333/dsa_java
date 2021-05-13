package com.hackerrank.interviewkit.greedyalgorithm;

import java.util.Arrays;

public final class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        int[] arr = {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};
        MinimumAbsoluteDifference difference = new MinimumAbsoluteDifference();
        long result = difference.findMinimum(arr);

        System.out.println("result = " + result);
    }

    public long findMinimum(int[] arr) {
        Arrays.sort(arr);
        long minimum = Long.MAX_VALUE;

        for(int i=0 ; i < arr.length-1 ; i++) {
            long diff = arr[i] - arr[i+1];
            minimum = Math.min(minimum, Math.abs(diff));
        }
        return minimum;
    }
}
