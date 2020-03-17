package org.geekforgeeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/*
https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays/0/
 */
public final class MergeSortedArrays {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noOfTests = Integer.parseInt(reader.readLine());

        for (int i = 0 ; i < noOfTests ; i++) {
            String arrayLengthStr = reader.readLine();
            String[] arrayLength = arrayLengthStr.split(" ");
            int arr1Length = Integer.parseInt(arrayLength[0]);
            int arr2Length = Integer.parseInt(arrayLength[1]);

            int[] arr1 = new int[arr1Length];
            int[] arr2 = new int[arr2Length];

            String arr1Str = reader.readLine();
            String arr2Str = reader.readLine();
            String[] arr1StrArr = arr1Str.split(" ");
            String[] arr2StrArr = arr2Str.split(" ");

            for (int j = 0 ; j < arr1Length ; j++) {
                arr1[j] = Integer.parseInt(arr1StrArr[j]);
            }
            for (int j = 0 ; j < arr2Length ; j++) {
                arr2[j] = Integer.parseInt(arr2StrArr[j]);
            }

            MergeSortedArrays solution = new MergeSortedArrays();
            solution.merge(arr1, arr2);

            PrintWriter writer = new PrintWriter(System.out);
            for (int j = 0 ; j < arr1.length ; j++) {
                writer.print(arr1[j] + " ");
            }
            for (int j = 0 ; j < arr2.length ; j++) {
                writer.print(arr2[j] + " ");
            }
            writer.println();
            writer.flush();
        }
    }

    /*
        Accepted
     */
    void merge_iteration_1(int[] arr1, int[] arr2) {
        if (arr1[arr1.length-1] <= arr2[0]) {
            return;
        }

        for (int i = arr1.length-1, j = 0; i >= 0 && j <arr2.length ; i--, j++) {
            if (arr1[i] > arr2[j]) {
                swap(arr1, arr2, i, j);
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    /* Time Limit exceeded
     Move the largest element in correct position and keep both arrays sorted.
     */
    void merge_iteration2(int[] arr1, int[] arr2) {
        for (int i = arr2.length-1 ; i >= 0; i--) {
            if (arr2[i] < arr1[arr1.length-1]) { //compare current pointer in arr2 with last element in arr1
                int temp = arr1[arr1.length-1]; //store last element of arr1 in temp
                int index  = Arrays.binarySearch(arr1, arr2[i]);

                //insert element at correct position.
                if (index < 0) {
                   index = -(index + 1);
                }

                for (int j = arr1.length-2 ; j >= index ; j--) {
                    arr1[j+1] = arr1[j];
                }
                arr1[index] = arr2[i];
                arr2[i] = temp;
            }
        }
    }

    /*
    Accepted
     */
    void merge(int[] arr1, int[] arr2) {
        int gap = arr1.length;

        while (gap >= 1) {
            int i = 0, j = gap;
            while (j <= arr1.length + arr2.length-1) {
                if (j > arr1.length -1) {
                    if (i <= arr1.length-1) {
                        if (arr1[i] > arr2[j-arr1.length]) {
                            swap(arr1,arr2, i, j-arr1.length);
                        }
                    } else {
                        if (arr2[i-arr1.length] > arr2[j-arr1.length]) {
                            swap(arr2, arr2, i-arr1.length, j-arr1.length);
                        }
                    }
                } else { //j < arr1.length-1
                    if (i < arr1.length-1) {
                        if (arr1[i] > arr1[j]) {
                            swap(arr1, arr1, i, j);
                        }
                    } else {
                        // this case won't exist
                    }
                }
                i++;
                j++;
            }
            if (gap == 1) {
                break;
            }
            gap = (gap/2) + (gap%2);
        }
    }

    void swap(int[] arr1, int[] arr2, int i, int j) {
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
}
