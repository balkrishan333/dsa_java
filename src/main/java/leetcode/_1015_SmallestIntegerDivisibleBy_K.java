package leetcode;

public class _1015_SmallestIntegerDivisibleBy_K {

    public static void main(String[] args) {
        _1015_SmallestIntegerDivisibleBy_K obj =
                new _1015_SmallestIntegerDivisibleBy_K();

        int k = 3;
        System.out.println(obj.smallestRepunitDivByK(k));
    }

    public int smallestRepunitDivByK(int k) {
        int remainder = 0;

        for (int length = 1; length <= k; length++) {
            /*
                we work with reminder instead of full number as full number can be very large. Using reminder works because of following
                mathematical property. (A * 10 + b) % K = ((A % K) * 10 + b) % K

                i.e. replacing number A by its remainder, gives the same result in context of modulo operation.
             */
            remainder = (remainder *10 +1) % k;
            if (remainder == 0) {
                return length;
            }
        }
        return -1;
    }
}
