package leetcode;

public class _326_PowerOfThree {

    public static void main(String[] args) {
        _326_PowerOfThree obj = new _326_PowerOfThree();

        int n = 243;
        System.out.println(obj.isPowerOfThree(n));
    }

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        /*
            We are talking about power. log and power are opposite of each other
            Calculate log of number and divide by log of 3. if number is a power of 3
            result of log division should not produce any remainder
         */
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
