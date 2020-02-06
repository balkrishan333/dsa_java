package org.geekforgeeks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://practice.geeksforgeeks.org/problems/count-the-triplets/0
 */

public class CountTriplets {

    private static final Logger logger = LoggerFactory.getLogger(CountTriplets.class);

    public static void main(String[] args) throws Exception {
        int[][] arrayList = readInput();

        CountTriplets triplets = new CountTriplets();
        for (int i = 0 ; i < arrayList.length ; i++) {
            int[] arr = arrayList[i];
            int count = triplets.count(arr);
            System.out.println(count != 0 ? count : -1);
        logger.info("count : " + count);
        }
    }

    int count(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = arr.length-1 ; i > 1 ; i--) {
            int j = 0;
            int k = i-1;

            while (j < k) {
                if (arr[j] + arr[k] == arr[i]) {
                    count++;
                    j++;
                    k--;
                } else if (arr[j] + arr[k] < arr[i]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }

    int count_factorial(int[] arr) {
        int maxElement = Integer.MIN_VALUE;

        //find max value in array
        for(int i = 0 ; i < arr.length ; i++) {
            maxElement = Math.max(arr[i], maxElement);
        }
        logger.info("maxElement : " + maxElement);

        //calculate frequency of each element
        int[] frequency = new int[maxElement+1];
        for(int i = 0 ; i < arr.length ; i++) {
            frequency[arr[i]]++;
        }
        logger.info("Frequency : " + Arrays.toString(frequency));

        int result = 0;

        //case 1: 0,0,0 --> C(freq(0), 3)
        result += frequency[0] * (frequency[0]-1) * (frequency[0]-2) / 6;

        //case 2: 0,x,x --> freq(0) * C(freq(i), 2)
        for (int i = 1 ; i <= maxElement ; i++) {
            result += frequency[0] * (frequency[i] * (frequency[i] -1)) / 2;
        }

        //case 3: x,x,2x --> freq(2x) * C(freq(x),2)
        for (int i = 1 ; i <= maxElement/2 ; i++) {
            if (frequency[i] >=2 && frequency[2*i] > 0) {
                result += frequency[2*i] * (frequency[i] * (frequency[i]-1))/2;
            }
        }

        //case 4: x,y,x+y --> freq(x) * freq(y) * freq(x+y)
        for (int i = 1 ; i <= maxElement ; i++) {
            for (int j = i+1 ; j <= maxElement ; j++) {
                if (i+j <= maxElement) {
                    result += frequency[i] * frequency[j] * frequency[i+j];
                }
            }
        }
        return result;
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
