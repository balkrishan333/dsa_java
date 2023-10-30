package leetcode;

import java.util.Arrays;

public class _1356_SortIntegersByTheNumberOf_1_Bits {

    public static void main(String[] args) {
        _1356_SortIntegersByTheNumberOf_1_Bits obj = new _1356_SortIntegersByTheNumberOf_1_Bits();

        int[] arr = {0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(obj.sortByBits(arr)));
    }

    public int[] sortByBits(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) -> {
            if (bitCount(a) == bitCount(b)) {
                return Integer.compare(a, b);
            }
            return bitCount( a) - bitCount(b);
        });

        return Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
    }

    private int bitCount(int num) {
        int mask = 1;
        int bits  = 0;

        while (num > 0) {
            bits = (num & mask) != 0 ? bits+1 : bits;
            num = num >> 1;
        }
        return bits;
    }
}
