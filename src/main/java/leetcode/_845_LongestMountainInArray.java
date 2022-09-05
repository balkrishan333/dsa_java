package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _845_LongestMountainInArray {

    public static void main(String[] args) {
        _845_LongestMountainInArray obj = new _845_LongestMountainInArray();

//        int[] arr = {2,1,4,7,3,2,5};
        int[] arr = {0,1,2,3,4,5,4,3,2,1,0};
        System.out.println(obj.longestMountain(arr));
    }

    public int longestMountain(int[] arr) {

        if (arr.length < 3) {
            return 0;
        }

        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i-1] < arr[i] && arr[i+1] < arr[i]) {
                peaks.add(i);
            }
        }

        int maxLength = 0;
        for (Integer peak : peaks) {
            int start = peak-1, end = peak+1;

            boolean up = true, down =true;
            while (up || down) {
                if (up && arr[start] < arr[start+1]) {
                    start--;
                    up = start >=0;
                } else {
                    up = false;
                }

                if (down && arr[end] < arr[end-1]) {
                    end++;
                    down = end < arr.length;
                } else {
                    down = false;
                }
            }

            //we have moved 1 place past the start and end of curve. Track back 1 place.
            start++;
            end--;

            maxLength = Math.max(maxLength, end-start+1);
        }
        return maxLength;
    }
}
