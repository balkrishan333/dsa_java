package leetcode;

public class _33_SearchInRotatedSortedArray {

    public static void main(String[] args) {
        _33_SearchInRotatedSortedArray obj = new _33_SearchInRotatedSortedArray();

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(obj.search(nums, target));
    }

    /*
        Approach: Binary Search

        Find out the pivot element(element around which sorting breaks). If array is rotated, first element is somewhere in middle of
        array. We need to find its index, and then we can do binary search in either half as both half are sorted.

        To find start of array, find out the left smallest element less than last element. If array is rotated, this element will be in
        middle of array or else it will be first element of array.
     */
    public int search(int[] nums, int target) {
        int n = nums.length;

        int lo = 0;
        int hi = n-1;

        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] > nums[n-1]) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }

        if (target >= nums[lo] && target <= nums[n-1]) {
            return binarySearch(nums, target, lo, n-1);
        }
        return binarySearch(nums, target, 0, lo-1);
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        int lo = start;
        int hi = end;

        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return -1;
    }
}
