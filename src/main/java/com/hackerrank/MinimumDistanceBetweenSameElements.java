package com.hackerrank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public final class MinimumDistanceBetweenSameElements {

    private static Logger logger = LoggerFactory.getLogger(MinimumDistanceBetweenSameElements.class);

    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 4, 1, 7};
        MinimumDistanceBetweenSameElements elements = new MinimumDistanceBetweenSameElements();
        int minDistance = elements.findDistance(arr);

        logger.info("minDistance : " + minDistance);
    }

    int findDistance(int[] arr) {
        int maxValue = Integer.MIN_VALUE;

        for(int i = 0 ; i < arr.length ; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        int[] indexArr = new int[maxValue+1];
        boolean[] diffArr = new boolean[maxValue+1];
        Arrays.fill(indexArr, -1);

        for (int i = 0 ; i < arr.length ; i++) {
            if (indexArr[arr[i]] == -1) {
                indexArr[arr[i]] = i;
            } else {
                indexArr[arr[i]] = i - indexArr[arr[i]];
                diffArr[arr[i]] = true;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0 ; i < diffArr.length ; i++) {
            if(diffArr[i] && indexArr[i] < result) {
                result = indexArr[i];
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
