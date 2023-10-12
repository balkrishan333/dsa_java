package leetcode;

public class _852_PeakIndexInAMountainArray {

    public static void main(String[] args) {
        _852_PeakIndexInAMountainArray obj = new _852_PeakIndexInAMountainArray();

        int[] arr = {0,10,5,2};
        System.out.println(obj.peakIndexInMountainArray(arr));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length-1;

        while (left < right) {
            int mid = (right-left)/2 + left;
            if (arr[mid] < arr[mid+1]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
