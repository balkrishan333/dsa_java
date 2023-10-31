package leetcode;

import java.util.Arrays;

public class _2433_FindTheOriginalArrayOfPrefixXor {

    public static void main(String[] args) {
        _2433_FindTheOriginalArrayOfPrefixXor obj = new _2433_FindTheOriginalArrayOfPrefixXor();

        int[] arr = {5,2,0,3,1};
        System.out.println(Arrays.toString(obj.findArray(arr)));
    }

    public int[] findArray(int[] pref) {
        int[] answer = new int[pref.length];
        answer[0] = pref[0];

        for (int i = 1; i < pref.length; i++) {
            answer[i] = pref[i] ^ pref[i-1];
        }

        return answer;
    }
}
