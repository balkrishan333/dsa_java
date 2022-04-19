package leetcode;

import java.util.Arrays;

public class BinarySearchWithIndex {

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
        int key = 7;

        System.out.println("Arrays.binarySearch(arr,key) = " + Arrays.binarySearch(arr,key));
        System.out.println("binarySearch(arr,key) = " +binarySearch(arr, key));
    }

    public static int binarySearch(int[] arr, int key) {
        if (key < arr[0]) {
            return -1;
        }

        if (key > arr[arr.length-1]) {
            return -(arr.length+1);
        }

        int lo = 0, hi = arr.length-1;
        int index = Integer.MIN_VALUE;

        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if (arr[mid] == key) {
                index = mid;
                break;
            }

            if (key <arr[mid]) {
                hi = mid-1;
                if (key > arr[hi]) {
                    index = -(hi+1);
                    break;
                }
            } else {
                lo = mid+1;
                if (key < arr[lo]) {
                    index = -(lo+1);
                    break;
                }
            }
        }
        return index;
    }
}
