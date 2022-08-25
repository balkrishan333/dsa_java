package leetcode;

public class _4_MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};

        _4_MedianOfTwoSortedArrays obj = new _4_MedianOfTwoSortedArrays();
        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int median = (nums1.length + nums2.length)/2;

        int[] merged = new int[median+1];

        int i =0, j=0, len =0;

        while ((i < nums1.length || j < nums2.length) && len <= median) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    merged[len++] = nums1[i++];
                } else {
                    merged[len++] = nums2[j++];
                }
            } else if (i < nums1.length) {
                merged[len++] = nums1[i++];
            } else if (j < nums2.length) {
                merged[len++] = nums2[j++];
            }
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (double) (merged[median] + merged[median-1])/2;
        }

        return merged[median];
    }
}
