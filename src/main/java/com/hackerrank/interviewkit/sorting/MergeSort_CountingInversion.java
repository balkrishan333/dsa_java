package com.hackerrank.interviewkit.sorting;

public class MergeSort_CountingInversion {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 1, 2}; //4
        MergeSort_CountingInversion countingInversion = new MergeSort_CountingInversion();
        long swaps  = countingInversion.count(arr);
        System.out.println("swaps = " + swaps);
    }

    public long count(int[] arr) {
        return merge(arr, 0, arr.length - 1).swaps;
    }

    private Info merge(int[] arr, int lo, int hi) {
        if (hi-lo == 0) {
            Info info = new Info();
            info.arr = new int[]{arr[lo]};
            info.swaps = 0;
            return info;
        }
        int mid = (hi+lo)/2;

        Info leftInfo = merge(arr, lo, mid);
        Info rightInfo = merge(arr, mid+1, hi);

        int[] left = leftInfo.arr;
        int[] right = rightInfo.arr;

        int[] merged = new int[left.length + right.length];

        long swaps = leftInfo.swaps + rightInfo.swaps;

        /*for (int k = left.length-1; k >= 0; k--) {
            for (int i = right.length-1; i >= 0; i--) {
                if (left[k] > right[i]) {
                    swaps =  swaps + (i+1);
                    break;
                }
            }
        }*/

        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
              merged[i+j] = left[i++];
            } else {
                swaps += left.length - i;
                merged[i+j] = right[j++];
            }
        }

        while (i < left.length) {
            merged[i+j] = left[i++];
        }

        while (j < right.length) {
            merged[i+j] = right[j++];
        }
        Info info = new Info();
        info.arr = merged;
        info.swaps = swaps;

        return info;
    }

    private static class Info {
        int[] arr;
        long swaps;
    }
}