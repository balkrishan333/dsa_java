package leetcode;

import java.util.Arrays;

public class _1502_CanMakeArithmeticProgressionFromSequence {

    public static void main(String[] args) {
        _1502_CanMakeArithmeticProgressionFromSequence obj = new _1502_CanMakeArithmeticProgressionFromSequence();

        int[] arr = {3,9,5,7,1};
        System.out.println(obj.canMakeArithmeticProgression(arr));
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i-1] != diff) {
                return false;
            }
        }
        return true;
    }
}
