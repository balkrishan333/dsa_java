package geekforgeeks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public final class Find_Kth_SmallestElement {

    private static final Logger logger = LoggerFactory.getLogger(Find_Kth_SmallestElement.class);

    public static void main(String[] args) throws Exception {

        Find_Kth_SmallestElement smallestElement = new Find_Kth_SmallestElement();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
        }
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
        for (int i = parent(arr.length-1); i >=0 ; i--) {
            maxHeapify(arr, i, k);
        }
        logger.info("Arrays.toString(arr) = " + Arrays.toString(arr));

        for (int i = k; i < arr.length ; i++) {
            if (arr[i] < arr[0]) {
                swap(arr, i, 0);
                maxHeapify(arr, 0, k);
            }
        }

        return arr[0];
    }

    int approach_4_quickSelect(int[] arr, int k) {
        return quickSelect(arr,0, arr.length-1,  k);
    }

    private int quickSelect(int[] arr, int lo, int hi, int k) {

        int pos = quickSortPartition(arr, lo, hi);

        // If position is same as k
        if (pos - lo == k - 1)
            return arr[pos];

        // If position is more, recur for
        // left subarray
        if (pos - lo > k - 1)
            return quickSelect(arr, lo, pos - 1, k);

        // Else recur for right subarray
        return quickSelect(arr, pos + 1, hi, k - pos + lo - 1);
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
        int largest = start;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != start) {
            swap(arr, start, largest);
            maxHeapify(arr, largest, heapSize);
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
        //middle element as pivot
        int pivot = (lo + hi) / 2;
        //swap pivot with last element - Intorduction to Algo. by coreman
        swap(arr, pivot, hi);

        int i = lo-1;
        int j = i+1;
        while (j <= hi-1) {
            //compare element with pivot - since pivot is at end
            if (arr[j] < arr[hi]) {
                //if jth element is less than pivot, it is at right place, move pointer and swap
                //to make sure this element is at new pointer
                i++;
                swap(arr, i, j);
            }
            j++;
        }
        //swap pivot with current pointer to make sure pivot is at right place
        swap(arr, i+1, hi);
        return i+1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
