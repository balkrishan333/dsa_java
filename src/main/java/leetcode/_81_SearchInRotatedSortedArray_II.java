package leetcode;

public class _81_SearchInRotatedSortedArray_II {
 
    public static void main(String[] args) {
        _81_SearchInRotatedSortedArray_II obj = new _81_SearchInRotatedSortedArray_II();

        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(obj.search(nums, target));
    }

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;

        //Tried with binary search bus due to duplicate elements does not work. Even the editorial on leetcode
        // suggests that worst case complexity will be O(N). So opted for linear search
        /*while (left <= right) {

            if (left == 0 && right - left < 2) {
                for (int i = left; i <= right; i++) {
                    if (nums[i] < nums[n-1]) {
                        left = i;
                        break;
                    }
                }
            }

            int mid = left + (right -left)/2;

            if (nums[mid] > nums[n-1]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }*/
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]){
                left = i;
                break;
            }
        }

       if (target >= nums[left] && target <= nums[n-1]) {
           return binarySearch(nums, target, left, n-1);
       }
       return binarySearch(nums, target, 0, left-1);
    }

    private boolean binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left)/2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] > target) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return false;
    }
}