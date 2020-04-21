package org.geekforgeeks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public final class Find_Kth_SmallestElement {

    private static Logger logger = LoggerFactory.getLogger(Find_Kth_SmallestElement.class);

    public static void main(String[] args) throws Exception {
//        int[] arr = {7, 10, 4, 3, 20, 15};
//        int[] arr = {7, 10, 4,  20, 15};
//        int[] arr = {10, 5, 7, 4, 2, 1, 3, 6, 8, 9};
        int[] arr = {12,5,787,1,23};
        int k = 2;

        Find_Kth_SmallestElement smallestElement = new Find_Kth_SmallestElement();
       /* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noOfTests = Integer.parseInt(reader.readLine());
        for (int i = 0; i < noOfTests; i++) {
            int arrSize = Integer.parseInt(reader.readLine());
            int[] arr = new int[arrSize];
            String[] arrStr = reader.readLine().split(" ");
            for (int j = 0; j < arrSize; j++) {
                arr[j] = Integer.parseInt(arrStr[j]);
            }
            int k = Integer.parseInt(reader.readLine());
            int kthSmallest = smallestElement.approach_4_quickSelect(arr, k);
            System.out.println(kthSmallest);
        }*/

        int kthSmallest;
//        kthSmallest = smallestElement.approach_1_sorting(arr, k);
        kthSmallest = smallestElement.approach_2_minHeap(arr, k);
//        kthSmallest = smallestElement.approach_3_maxHeap(arr, k);
//        kthSmallest = smallestElement.approach_4_quickSelect(arr, k);
        System.out.println("kthSmallest = " + kthSmallest);
    }

    int approach_1_sorting(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        logger.info("Arrays.toString(arr) = " + Arrays.toString(arr));
        return arr[k - 1];
    }

    int approach_2_minHeap(int[] arr, int k) {
        for (int i = parent(arr.length-1); i >=0 ; i--) {
            minHeapify(arr, i, arr.length - 1);
        }

        for (int i = 0; i < k-1; i++) {
            swap(arr, 0, arr.length-1-i);
            minHeapify(arr, 0, arr.length-1-(i+1));
        }
        return arr[0];
    }

    int approach_3_maxHeap(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            maxHeapify(arr, i, k);
        }
        logger.info("Arrays.toString(arr) = " + Arrays.toString(arr));

        for (int i = k; i < arr.length-1 ; i++) {
            if (arr[i] < arr[0]) {
                swap(arr, i, 0);
                maxHeapify(arr, 0, arr.length-1);
            }
        }

        return arr[0];
    }

    int approach_4_quickSelect(int[] arr, int k) {
        return quickSelect(arr, k, 0, arr.length-1);
    }

    private int quickSelect(int[] arr, int k, int lo, int hi) {

        int pivot = quickSortPartition(arr, lo, hi);
        if (pivot == k-1) {
            return arr[pivot];
        }
        if (pivot > k-1) {
           return quickSelect(arr, k, 0, pivot-1);
        } else {
            return quickSelect(arr, k, pivot + 1, hi);
        }
    }

    private void minHeapify(int[] arr, int start, int heapSize) {
        if (start < 0) {
            return;
        }

        int left = left(start);
        int right = right(start);
        int smallest = start;

        if (left <= heapSize && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right <= heapSize && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != start) {
            swap(arr, start, smallest);
            minHeapify(arr, smallest, heapSize);
        }
    }

    private void maxHeapify(int[] arr, int start, int heapSize) {
        if (start < 0) {
            return;
        }

        int left = left(start);
        int right = right(start);
        int smallest = start;

        if (left <= heapSize && arr[left] > arr[smallest]) {
            smallest = left;
        }
        if (right <= heapSize && arr[right] > arr[smallest]) {
            smallest = right;
        }
        if (smallest != start) {
            swap(arr, start, smallest);
            minHeapify(arr, smallest, heapSize);
        }
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = quickSortPartition(arr, lo, hi);
            quickSort(arr, 0, pivot);
            quickSort(arr, pivot + 1, hi);
        }
    }

    private int quickSortPartition(int[] arr, int lo, int hi) {
        int pivot = (lo + hi) / 2;
        int i = lo;
        int j = hi;

        while (arr[i] < arr[pivot]) {
            i++;
        }

        while (arr[j] > arr[pivot]) {
            j--;
        }

        if (i < j) {
            swap(arr, i, j);
        }
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
