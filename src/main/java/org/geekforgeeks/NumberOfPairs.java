package org.geekforgeeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://www.geeksforgeeks.org/find-number-pairs-xy-yx/
 */
public final class NumberOfPairs {

//    private static final Logger logger = LoggerFactory.getLogger(NumberOfPairs.class);

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int noOfTests = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < noOfTests ; i++) {
            String arraySizeStr = bufferedReader.readLine();
            String arr1ElementStr = bufferedReader.readLine();
            String arr2ElementStr = bufferedReader.readLine();

            String[] arraySizes = arraySizeStr.split(" ");
            int[] arr1 = new int[Integer.parseInt(arraySizes[0])];
            int[] arr2 = new int[Integer.parseInt(arraySizes[1])];

            String[] arr1ElementsStrArr = arr1ElementStr.split(" ");
            for (int j = 0 ; j < arr1.length ; j++) {
                arr1[j] = Integer.parseInt(arr1ElementsStrArr[j]);
            }

            String[] arr2ElementsStrArr = arr2ElementStr.split(" ");
            for (int j = 0 ; j < arr2.length ; j++) {
                arr2[j] = Integer.parseInt(arr2ElementsStrArr[j]);
            }

            NumberOfPairs pairs = new NumberOfPairs();
            long count = pairs.count(arr1, arr2);
            System.out.println(count);
        }
    }

    long count(int[] arr1, int[] arr2) {
        long count = 0;

        Arrays.sort(arr2);

        int[] countArr2 = new int[3];
        //count no.of 0's, 1's and 2's in arr2
        for (int i = 0; i < arr2.length ; i++) {
            if (arr2[i] > 2) {
                //since array is sorted, first occurance of element greater than 1 means, no 0's, 1's and 2's are left
                break;
            }
            countArr2[arr2[i]]++;
        }

        for (int i = 0 ; i < arr1.length ; i++) {
            if (arr1[i] == 0) {
                continue;
            }
            if (arr1[i] == 1) {
                count += countArr2[0];
            }

            if (arr1[i] == 2 || arr1[i] == 4)  {
                //find index of first element larger than 4
                count += doBinarySearch(arr2, 5);

                if (arr1[i] == 2) {
                    count += countArr2[0] + countArr2[1];
                }

                if (arr1[i] == 4) {

                    count += countArr2[0] + countArr2[1];
                }
            }

            if (arr1[i] == 3) {
                count += doBinarySearch(arr2, 4);
                count += countArr2[0] + countArr2[1] + countArr2[2];
            }

            if (arr1[i] >= 5) {
                 //find index of first element larger than arr1[i]
                count += doBinarySearch(arr2, arr1[i]+1);
                 count += countArr2[0] + countArr2[1];
             }
        }

/*
         for (int i = 0; i < arr1.length ; i++) {
            for(int j = 0 ; j < arr2.length ; j++) {
                if (arr1[i] > 4 && arr2[j] > 4) {
                    if (arr2[j] > arr1[i]) {
                        System.out.println("i, j = " + arr1[i] + " , " + arr2[j]);
                        count++;
                    }
                } else {
                    if (Math.pow(arr1[i], arr2[j]) > Math.pow(arr2[j], arr1[i]) ) {
                        System.out.println("i, j = " + arr1[i] + " , " + arr2[j]);
                        count++;
                    }
                }
            }
        }*/
        return count;
    }

    private long doBinarySearch(int[] arr, int searchKey) {
        long count = 0;
        int index = Arrays.binarySearch(arr, searchKey);
        if (index == 0) {
            count = arr.length;
        } else if (index > 0) { //element found in array
         /*
          In case of duplicate elements, Binary search does not gaurantee that first index will be returned.
           Iterate over previous elements until you find mismatch and store first index in calibratedIndex.
          */
            int calibratedIndex = index;
            for (int iii = index -1; iii >=0 ; iii--) {
                if (arr[iii] != searchKey) {
                    break;
                }
                calibratedIndex--;
            }
            count = arr.length - calibratedIndex;
        } else {
            count = arr.length + (index +1);
        }
        return count;
    }
}
