package com.hackerrank.interviewkit.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public final class LeftRotation {

    private static Logger logger = LoggerFactory.getLogger(LeftRotation.class);

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int rotateBy = 4;
        int[] result = new LeftRotation().run(arr, rotateBy);

        logger.info("Result : {}", Arrays.toString(result));
    }

    int[] run(int[] arr, int rotateBy) {

        if (rotateBy == arr.length || arr.length == 0) {
            return arr;
        }

        int[] result = new int[arr.length];
        int index = 0;

        for (int i = rotateBy; i < arr.length; i++) {
            result[index++] = arr[i];
        }

        for (int i = 0; i < rotateBy; i++) {
            result[index++] = arr[i];
        }

        return result;
    }
}
