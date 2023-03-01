package leetcode;

import java.util.Arrays;

public class _912_SortAnArray {

    public static void main(String[] args) {
        _912_SortAnArray obj = new _912_SortAnArray();

        int[] nums = {6,5,4,3,2,1};
        System.out.println(Arrays.toString(obj.sortArray(nums)));
    }

    public int[] sortArray(int[] nums) {
//        quickSort(nums, 0, nums.length-1);
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);

        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] leftArr = new int[mid-left+1];
        int[] rightArr = new int[right-mid];

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = nums[left+i];
        }

        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = nums[mid+i+1];
        }

        int i = 0, j = 0;
        int index = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                nums[index] = leftArr[i];
                i++;
            } else {
                nums[index] = rightArr[j];
                j++;
            }
            index++;
        }

        while (i < leftArr.length) {
            nums[index++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            nums[index++] = rightArr[j++];
        }
    }

    /*
        Since worst case complexity is O(n^2), solution times out
     */
    private void quickSort(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return;
        }

        int pivot = nums[hi];
        int index = lo-1;

        for (int i = lo; i < hi ; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, ++index);
            }
        }
        swap(nums, ++index, hi); //bring pivot to correct position
        quickSort(nums, lo, index-1);
        quickSort(nums, index+1, hi);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
