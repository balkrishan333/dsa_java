package leetcode;

import java.util.Arrays;

public class MergeSortedArray_88 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m=3, n= 3;

        mergeArrays(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    private static void mergeArrays(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            int index = BinarySearchWithIndex.binarySearch(Arrays.copyOf(nums1,m), nums2[i]);

            if (index < 0) {
                index = Math.abs(index+1);
            }

            if (index >= m) {
                nums1[m] = nums2[i];
            } else {
                for (int j = m-1; j >= index; j--) {
                    nums1[j+1] = nums1[j];
                    nums1[index] = nums2[i];
                }
            }
            m++;
        }
    }
}
