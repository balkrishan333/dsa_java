package leetcode;

import java.util.Arrays;

public class _34_FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        _34_FindFirstAndLastPositionOfElementInSortedArray obj = new _34_FindFirstAndLastPositionOfElementInSortedArray();

//        int[] nums = {5,7,7,8,8,10};
//        int target = 8;

        int[] nums = {1};
        int target = 1;

        System.out.println(Arrays.toString(obj.searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        return withbBinarySearch(nums, target, 0, nums.length-1);
    }

    public int[] withbBinarySearch(int[] nums, int target, int start, int end) {
        int mid = (start+end)/2;

        if (start > end) {
            return new int[] {-1, -1};
        }

        if (nums[mid] == target) {
            int i = mid-1;
            while (i >=0 && nums[i] == target) {
                i--;
            }
            int j = mid+1;
            while (j < nums.length && nums[j] == target) {
                j++;
            }
            return new int[] {i+1, j-1};
        }

        if (nums[mid] < target) {
            return withbBinarySearch(nums, target, mid+1, end);
        }

        return withbBinarySearch(nums, target, 0, mid-1);
    }
}
