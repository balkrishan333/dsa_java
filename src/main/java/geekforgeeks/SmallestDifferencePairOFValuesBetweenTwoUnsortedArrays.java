package geekforgeeks;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/smallest-difference-pair-values-two-unsorted-arrays/
 */
public class SmallestDifferencePairOFValuesBetweenTwoUnsortedArrays {

    public static void main(String[] args) {
        SmallestDifferencePairOFValuesBetweenTwoUnsortedArrays obj = new SmallestDifferencePairOFValuesBetweenTwoUnsortedArrays();

        int A[] = {1, 3, 15, 11, 2};
        int B[] = {23, 127, 235, 19, 8};

        System.out.println(Arrays.toString(obj.findSmallestDiff(A,B)));
    }

    private int[] findSmallestDiff(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int min = Integer.MAX_VALUE, i =0, j=0;
        int[] result = new int[2];

        while (i < a.length && j < b.length) {
            int currMin = Math.abs(a[i] - b[j]);
            if (currMin < min) {
                min = currMin;
                result[0] = a[i];
                result[1] = b[j];
            }

            if (min == 0) {
                return result;
            }

            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}
