package leetcode;

import java.util.Arrays;

public class _1846_MaximumElementAfterDecreasingAndRearranging {

    public static void main(String[] args) {
        _1846_MaximumElementAfterDecreasingAndRearranging obj = new _1846_MaximumElementAfterDecreasingAndRearranging();

        int[] arr = {100,1,1000};
        System.out.println(obj.maximumElementAfterDecrementingAndRearranging(arr));
    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }

        Arrays.sort(arr);
        //set first element to 1, irrespective of its current value as that is a requirement
        arr[0] = 1;

        //for each element if difference with previous is more than 1, change the value and set to 1 more than previous. This will make
        // sure difference between all adjacent elements is not more than 1
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i-1]) > 1) {
                arr[i] = arr[i-1] +1;
            }
        }
        return arr[arr.length-1];
    }
}
