package leetcode;

import java.util.Arrays;

public class _1720_DecodeXORedArray {

    public static void main(String[] args) {
        _1720_DecodeXORedArray obj = new _1720_DecodeXORedArray();

        int[] encoded = {1,2,3};
        int first = 1;
        System.out.println(Arrays.toString(obj.decode(encoded, first)));
    }

    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length+1];
        arr[0] = first;

        for (int i = 0; i < encoded.length; i++) {
            arr[i+1] = arr[i] ^ encoded[i];
        }
        return arr;
    }
}
