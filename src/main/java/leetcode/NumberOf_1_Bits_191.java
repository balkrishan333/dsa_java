package leetcode;

public class NumberOf_1_Bits_191 {

    public static void main(String[] args) {
        NumberOf_1_Bits_191 obj = new NumberOf_1_Bits_191();
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
