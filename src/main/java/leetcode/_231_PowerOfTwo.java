package leetcode;

public class _231_PowerOfTwo {

    public static void main(String[] args) {
        _231_PowerOfTwo obj = new _231_PowerOfTwo();

        int n = 5;
        System.out.println(obj.isPowerOfTwo(n));
    }

    public boolean isPowerOfTwo(int n) {
       return n > 0 && Integer.bitCount(n) == 1;
    }
}
