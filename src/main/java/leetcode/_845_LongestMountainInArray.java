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
            int i = peak-1, j = peak+1;

            boolean up = true, down =true;
            while (up || down) {
                if (up && arr[i] < arr[i+1]) {
                    i--;
                    up = i >=0;
                } else {
                    up = false;
                }

                if (down && arr[j] < arr[j-1]) {
                    j++;
                    down = j < arr.length;
                } else {
                    down = false;
                }
            }

            //we have moved 1 place past the start and end of curve. Track back 1 place.
            i++;
            j--;

            maxLength = Math.max(maxLength, j-i+1);
        }
        return maxLength;
    }
}
