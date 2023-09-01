package leetcode;

import java.util.Arrays;

public class _338_CountingBits {

    public static void main(String[] args) {
        _338_CountingBits obj = new _338_CountingBits();

        int n = 5;
        System.out.println(Arrays.toString(obj.countBits(n)));
    }

    /*
        Approach:

        For even numbers count is same as half of the number. Eg: 4 and 8 have same 1's, 8 and 16 have same 1's

        For odd numbers, we need to add 1 to half of the number because with right shift, we will loss the right most 1

        When it comes to even numbers, i.e, 2,4,6,8, their binary should be like '10', '100', '110', '1000' so one notable difference
        is their unit digit is always 0, which means when you call >> 1- shift one bit rightwards and also means dividing by 2-
        would cause no change to the count of '1' in the binary string.

        On other hand, when you meet odd numbers, shifting one bit rightwards always eliminates one '1' digit from original binary string,
        that is why we should "compensate" one '1' character to the count.

     */
    public int[] countBits(int n) {

        int[] result = new int[n+1];

        for (int i = 0; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
