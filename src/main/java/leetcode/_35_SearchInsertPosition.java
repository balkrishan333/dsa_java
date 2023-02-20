package leetcode;

import java.util.Arrays;

public class _35_SearchInsertPosition {

    public static void main(String[] args) {
        _35_SearchInsertPosition obj = new _35_SearchInsertPosition();

        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(obj.searchInsert(nums, target));
    }

    /*
        Binary search implementation
     */
    public int searchInsert(int[] nums, int target) {
        int lo =0, hi = nums.length-1;

        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        //lo points to start of array which potentially can have target, so lo is the smallest index at which
        //target can appear if it does not exist in array
        return lo;
    }

    /*
        Using built in binary search
     */
    public int searchInsert_v1(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index >= 0 ? index : Math.abs(index + 1);
    }
}
