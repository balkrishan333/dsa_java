package geekforgeeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class EquilibriumPoint {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noOfTests = Integer.parseInt(reader.readLine());
        EquilibriumPoint equilibriumPoint = new EquilibriumPoint();
        for (int i = 0; i < noOfTests; i++) {
            int arrSize = Integer.parseInt(reader.readLine());
            int[] arr = new int[arrSize];

            String[] arrElements = reader.readLine().split(" ");
            for (int j = 0; j < arrSize; j++) {
                arr[j] = Integer.parseInt(arrElements[j]);
            }

            int point = equilibriumPoint.find(arr);
            System.out.println(point);
        }

    }

    int find(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        if (arr.length == 2) {
            return -1;
        }

       int i = 0, j = arr.length-1;
       int sumFromBegin = arr[i];
       int sumFromEnd = arr[j];

        while ((j - i) > 2) {
            if (sumFromBegin < sumFromEnd) {
                sumFromBegin += arr[++i];
            } else if (sumFromBegin > sumFromEnd) {
                sumFromEnd += arr[--j];
            } else {
                sumFromBegin += arr[++i];
                sumFromEnd += arr[--j];
            }
        }

        if (sumFromBegin == sumFromEnd) {
            return i+2;
        } else {
            return  -1;
        }
    }
}
