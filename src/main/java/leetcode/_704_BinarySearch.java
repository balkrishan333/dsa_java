package leetcode;

public class _704_BinarySearch {

    public static void main(String[] args) {
        _704_BinarySearch obj = new _704_BinarySearch();

        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(obj.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;

        while (lo <= hi) {
            int mid = lo+ (hi-lo)/2;
            if(nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return -1;
    }
}
