package leetcode;

public class _1095_FindInMountainArray {

    public static void main(String[] args) {
        _1095_FindInMountainArray obj = new _1095_FindInMountainArray();

        System.out.println(obj.findInMountainArray(3, new MountainArray()));
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        // Save the length of the mountain array
        int length = mountainArr.length();

        // 1. Find the index of the peak element
        int low = 1;
        int high = length - 2;
        while (low != high) {
            int testIndex = (low + high) / 2;
            if (mountainArr.get(testIndex) < mountainArr.get(testIndex + 1)) {
                low = testIndex + 1;
            } else {
                high = testIndex;
            }
        }
        int peakIndex = low;

        // 2. Search in the strictly increasing part of the array
        low = 0;
        high = peakIndex;
        while (low != high) {
            int testIndex = (low + high) / 2;
            if (mountainArr.get(testIndex) < target) {
                low = testIndex + 1;
            } else {
                high = testIndex;
            }
        }
        // Check if the target is present in the strictly increasing part
        if (mountainArr.get(low) == target) {
            return low;
        }

        // 3. Otherwise, search in the strictly decreasing part
        low = peakIndex + 1;
        high = length - 1;
        while (low != high) {
            int testIndex = (low + high) / 2;
            if (mountainArr.get(testIndex) > target) {
                low = testIndex + 1;
            } else {
                high = testIndex;
            }
        }
        // Check if the target is present in the strictly decreasing part
        if (mountainArr.get(low) == target) {
            return low;
        }

        // Target is not present in the mountain array
        return -1;
    }
}

class MountainArray {

      private int[] arr = {1,5,3};
      public int get(int index){
        return arr[index];
      }
      public int length() {
            return arr.length;
      }
}
