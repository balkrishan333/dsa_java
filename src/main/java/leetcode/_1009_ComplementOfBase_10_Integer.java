package leetcode;

public class _1009_ComplementOfBase_10_Integer {

    public static void main(String[] args) {
        _1009_ComplementOfBase_10_Integer obj = new
                _1009_ComplementOfBase_10_Integer();

        int n = 5;
        System.out.println(obj.bitwiseComplement(n));
    }

    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        /*
            Normally ~n flips all 32 bits, but we only want to flip the significant bits (the ones actually used by the number).
            For example, n = 5 → binary 101, complement should be 010 = 2, not the 32-bit flip result.

            So, we create a mask of all 1's equal to the length of no. of binary representation of number.
         */
        int mask = (1 << Integer.toBinaryString(n).length()) - 1;
        return n ^ mask;
    }
}
