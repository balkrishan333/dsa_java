package leetcode;

public class ReverseBits_190 {

    public static void main(String[] args) {
        ReverseBits_190 obj = new ReverseBits_190();
        int n = 43261596;
        System.out.println(obj.reverseBits(n));
    }

    public int reverseBits(int n) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            n >>= 1;
            result <<= 1;

            result = result | bit;
        }
        return result;
    }
}
