package leetcode;

import java.util.Arrays;

public class _2657_FindThePrefixCommonArrayOfTwoArrays {

    public static void main(String[] args) {
        _2657_FindThePrefixCommonArrayOfTwoArrays obj = new _2657_FindThePrefixCommonArrayOfTwoArrays();

        int[] A = {1,3,2,4}, B = {3,1,2,4};
        System.out.println(Arrays.toString(obj.findThePrefixCommonArray(A, B)));
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int arrLength = A.length; //size of both arrays is equal
        int[] frequency = new int[arrLength+1]; //each array contains elements from 1 to arrLength

        int[] commonPrefix = new int[arrLength];

        int commonCount = 0;
        for (int i = 0; i < arrLength; i++) {

            frequency[A[i]]++;
            if (frequency[A[i]] == 2) {
                commonCount++;
            }

            frequency[B[i]]++;
            if (frequency[B[i]] == 2) {
                commonCount++;
            }
            commonPrefix[i] = commonCount;
        }
        return commonPrefix;
    }
}
