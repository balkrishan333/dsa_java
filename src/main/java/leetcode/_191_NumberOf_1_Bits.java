package leetcode;

public class _191_NumberOf_1_Bits {

    public static void main(String[] args) {
        _191_NumberOf_1_Bits obj = new _191_NumberOf_1_Bits();
        int n = 00000000000000000000000000001011;

        System.out.println(obj.hammingWeight(n));
    }

    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            if((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
