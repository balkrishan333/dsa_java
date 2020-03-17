package org.geekforgeeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately/0/
 */
public final class RearrangeArrayAlternatively {

    public static void main(String[] args) throws Exception {

        long[][] inputArrList = readInput();

        for (int i = 0 ; i < inputArrList.length ; i++) {
            RearrangeArrayAlternatively solution = new RearrangeArrayAlternatively();
            long[] result = solution.rearrange(inputArrList[i]);
            Arrays.stream(result).forEach(value -> System.out.print(value + " "));
            System.out.println();
        }
    }

    long[] rearrange(long[] arr) {
        int maxIndex = arr.length -1;
        int minIndex = 0;

        long maxElement = arr[maxIndex]+1;

        for (int i = 0; i < arr.length ; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[maxIndex] % maxElement) * maxElement;
                maxIndex--;
            } else {
                arr[i] += (arr[minIndex] % maxElement) * maxElement;
                minIndex++;
            }
        }

        for (int i = 0 ; i < arr.length ; i++) {
            arr[i] = arr[i] / maxElement;
        }

        return arr;
    }

    private static long[][] readInput() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testsCount = Integer.parseInt(reader.readLine());

        long[][] inArrayList = new long[testsCount][];

        for (int i = 0 ; i < testsCount ; i++) {
            String line_1 = reader.readLine();
            String line_2 = reader.readLine();

            String[] line_2_split = line_2.split(" ");

            int inArraySize = Integer.parseInt(line_1);

            long[] inArray = new long[inArraySize];
            for (int ii = 0; ii < inArraySize ; ii++) {
                inArray[ii] = Integer.parseInt(line_2_split[ii]);
            }
            inArrayList[i] = inArray;
        }
        return inArrayList;
    }
}
